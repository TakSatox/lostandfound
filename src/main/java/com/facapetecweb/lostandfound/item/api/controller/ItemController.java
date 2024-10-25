package com.facapetecweb.lostandfound.item.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facapetecweb.lostandfound.item.api.request.ItemRequest;
import com.facapetecweb.lostandfound.item.api.response.ItemResponse;
import com.facapetecweb.lostandfound.item.model.entity.Item;
import com.facapetecweb.lostandfound.item.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@Tag(name = "Items")
@Validated
public class ItemController {

    private final ItemService service;
    
    @Operation(summary = "Publish Item")
    @ApiResponse(
        responseCode = "201",
        description = "CREATED",
        content = @Content(schema = @Schema(implementation = ItemResponse.class))
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemResponse create(
        @Parameter(
            description = "Item Request Data",
            schema = @Schema(implementation = ItemRequest.class)
        )
        @RequestBody ItemRequest req
    ) {
        return ItemResponse.from(service.save(ItemRequest.toEntity(req)));
    }


    @Operation(summary = "List Items")
    @ApiResponse(
        responseCode = "200",
        description = "OK",
        content = @Content(array = @ArraySchema(schema = @Schema(implementation = ItemResponse.class)))
    )
    @GetMapping
    public List<ItemResponse> list() {
        return ItemResponse.fromList(service.getAll());
    }


    @Operation(summary = "Get One Item")
    @ApiResponse(
        responseCode = "200",
        description = "OK",
        content = @Content(schema = @Schema(implementation = ItemResponse.class))
    )
    @GetMapping("/{id}")
    public ItemResponse getOne(
        @Parameter(
            description = "Item ID",
            schema = @Schema(type = "integer", format = "int64", maximum = "99999", minimum = "1")
        )
        @PathVariable Long id
    ) {

        Optional<Item> item = service.getById(id);

        if (item.isPresent()) {
            return ItemResponse.from(item.get());
        }

        return null;

    }
    
    @Operation(summary = "Update Item")
    @ApiResponse(
        responseCode = "204",
        description = "NO CONTENT"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(
        @Parameter(
            description = "Item ID",
            schema = @Schema(type = "integer", format = "int64", maximum = "99999", minimum = "1")
        )
        @PathVariable Long id,
        @Parameter(
            description = "Item Request Data",
            schema = @Schema(implementation = ItemRequest.class)
        )
        @RequestBody ItemRequest req
    ) {
        service.update(id, ItemRequest.toEntity(req));
    }


    @Operation(summary = "Delete Item")
    @ApiResponse(
        responseCode = "204",
        description = "NO CONTENT"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
        @Parameter(
            description = "Item ID",
            schema = @Schema(type = "integer", format = "int64", maximum = "99999", minimum = "1")
        )
        @PathVariable Long id
    ) {
        service.deleteById(id);
    }

}
