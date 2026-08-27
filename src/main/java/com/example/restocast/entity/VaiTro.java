package com.example.restocast.entity;

import com.example.restocast.entity.NguoiDung;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "VaiTro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VaiTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_vai_tro", nullable = false, unique = true, length = 50)
    private String tenVaiTro;

    @OneToMany(mappedBy = "vaiTro")
    private List<NguoiDung> nguoiDungs;
}