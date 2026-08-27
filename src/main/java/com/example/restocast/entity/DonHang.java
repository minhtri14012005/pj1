package com.example.restocast.entity;

import com.example.restocast.entity.NguoiDung;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DonHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DonHang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nguoi_tao_id")
    private NguoiDung nguoiTao;

    @Column(name = "thoi_gian_tao")
    private LocalDateTime thoiGianTao;

    @Column(name = "tong_tien", nullable = false, precision = 12, scale = 2)
    private BigDecimal tongTien;

    @Column(name = "thoi_tiet", length = 50)
    private String thoiTiet;

    @Column(name = "la_ngay_le")
    private Boolean laNgayLe = false;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> chiTietDonHangs;

    @PrePersist
    protected void onCreate() {
        if (thoiGianTao == null) {
            thoiGianTao = LocalDateTime.now();
        }
    }
}