package com.backend.imnotascam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_black_list")
@NoArgsConstructor
public class TBlackList {

    @Id
    @SequenceGenerator(
            name = "blackList_sequence",
            sequenceName = "blackList_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "blackList_sequence"
    )
    private Long id;

    @Column
    private String url;

    public TBlackList(String url) {
        this.url = url;
    }
}
