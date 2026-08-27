package com.example.restocast.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "MonAn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MonAn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_mon_an", nullable = false, length = 100)
    private String tenMonAn;

    @Column(name = "gia_ban", nullable = false, precision = 10, scale = 2)
    private BigDecimal giaBan;

    @Column(name = "trang_thai_phuc_vu")
    private Boolean trangThaiPhucVu = true;

    @OneToMany(mappedBy = "monAn")
    private List<DinhLuong> dinhLuongs;

    @OneToMany(mappedBy = "monAn")
    private List<ChiTietDonHang> chiTietDonHangs;
}