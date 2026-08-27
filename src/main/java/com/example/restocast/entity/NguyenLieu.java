package com.example.restocast.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "NguyenLieu")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NguyenLieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_nguyen_lieu", nullable = false, length = 100)
    private String tenNguyenLieu;

    @Column(name = "don_vi_tinh", nullable = false, length = 20)
    private String donViTinh;

    @Column(name = "so_luong_ton_kho")
    private Float soLuongTonKho = 0F;

    @OneToMany(mappedBy = "nguyenLieu")
    private List<DinhLuong> dinhLuongs;
}