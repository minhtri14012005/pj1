package com.example.restocast.entity;

import com.example.restocast.entity.MonAn;
import com.example.restocast.entity.NguyenLieu;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "DinhLuong")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DinhLuong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_an_id")
    private MonAn monAn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguyen_lieu_id")
    private NguyenLieu nguyenLieu;

    @Column(name = "so_luong_can_thiet", nullable = false)
    private Float soLuongCanThiet;
}