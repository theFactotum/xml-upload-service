package com.task.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "device_info")
public class DeviceInfoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name= "name")
    private  String name;

    @Column(name= "screen_width")
    private String screen_width;

    @Column(name= "screen_height")
    private String screen_height;

    @Column(name= "screen_dpi")
    private String screen_dpi;

    @Column(name= "screen_newspapername")
    private String screen_newspapername;

    @Column(name= "filename")
    private String filename;


    @Column(name= "uploadtime")
    private LocalDateTime uploadtime;



    @Override
    public String toString() {
        return "DeviceInfoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
