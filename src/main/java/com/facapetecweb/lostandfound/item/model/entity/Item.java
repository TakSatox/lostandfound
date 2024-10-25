package com.facapetecweb.lostandfound.item.model.entity;

import java.time.LocalDate;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "TW_T1_ITEM", schema = "lostandfound")
@NoArgsConstructor
@DynamicUpdate
public class Item {

    @Id
    @Column(name = "T1_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T1_ITEM_ID_SEQ_GEN")
    @SequenceGenerator(name = "T1_ITEM_ID_SEQ_GEN", sequenceName = "T1_ITEM_ID_SEQ", allocationSize = 1, schema = "lostandfound")
    private Long id;
    
    @Column(name = "T1_TITLE")
    private String title;

    @Column(name = "T1_PICTURE_LINK")
    private String pictureLink;

    @Column(name = "T1_CURRENT_LOCATION")
    private String currentLocation;

    @Column(name = "T1_FOUND_LOCATION")
    private String foundLocation;

    @Column(name = "T1_FOUND_DATE")
    private LocalDate foundDate;

    @Column(name = "T1_WHO_FOUND")
    private String whoFound;

    @Column(name = "T1_IS_RETRIEVED")
    private Boolean isRetrieved;

    @Column(name = "T1_WHO_RETRIEVED")
    private String whoRetrieved;

    @Column(name = "T1_RETRIEVED_DATE")
    private LocalDate retrievedDate;

}
