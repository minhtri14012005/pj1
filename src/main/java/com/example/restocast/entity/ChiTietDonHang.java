package com.example.restocast.entity;

import com.example.restocast.entity.DonHang;
import com.example.restocast.entity.MonAn;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ChiTietDonHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChiTietDonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "don_hang_id")
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mon_an_id")
    private MonAn monAn;

    @Column(name = "so_luong_ban", nullable = false)
    private Integer soLuongBan;

    @Column(name = "don_gia", nullable = false, precision = 10, scale = 2)
    private BigDecimal donGia;
}