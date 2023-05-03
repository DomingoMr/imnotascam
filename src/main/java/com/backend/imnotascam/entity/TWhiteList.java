package com.backend.imnotascam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "t_white_list")
@NoArgsConstructor
public class TWhiteList {

    @Id
    @SequenceGenerator(
            name = "whiteList_sequence",
            sequenceName = "whiteList_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "whiteList_sequence"
    )
    private Long id;

    @Column
    private String url;

    public TWhiteList(String url) {
        this.url = url;
    }
}
