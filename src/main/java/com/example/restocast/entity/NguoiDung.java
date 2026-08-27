package com.example.restocast.entity;

import com.example.restocast.entity.DonHang;
import com.example.restocast.entity.VaiTro;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "NguoiDung")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_dang_nhap", nullable = false, unique = true, length = 50)
    private String tenDangNhap;

    @Column(name = "mat_khau", nullable = false, length = 255)
    private String matKhau;

    @Column(name = "ho_ten", length = 100)
    private String hoTen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vai_tro_id")
    private VaiTro vaiTro;

    @Column(name = "trang_thai")
    private Boolean trangThai = true;

    @OneToMany(mappedBy = "nguoiTao")
    private List<DonHang> donHangs;
}