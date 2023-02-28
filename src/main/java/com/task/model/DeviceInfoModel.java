package com.task.model;

import javax.persistence.*;
import java.time.LocalDateTime;

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


    public DeviceInfoModel() {
    }

    public DeviceInfoModel(String name,
                           String screen_width,
                           String screen_height,
                           String screen_dpi,
                           String screen_newspapername,
                           String filename,
                           LocalDateTime uploadtime
    ) {
        this.name = name;
        this.screen_width = screen_width;
        this.screen_height = screen_height;
        this.screen_dpi = screen_dpi;
        this.screen_newspapername = screen_newspapername;
        this.filename = filename;
        this.uploadtime = uploadtime;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreen_width() {
        return screen_width;
    }

    public void setScreen_width(String screen_width) {
        this.screen_width = screen_width;
    }

    public String getScreen_height() {
        return screen_height;
    }

    public void setScreen_height(String screen_height) {
        this.screen_height = screen_height;
    }

    public String getScreen_dpi() {
        return screen_dpi;
    }

    public void setScreen_dpi(String screen_dpi) {
        this.screen_dpi = screen_dpi;
    }

    public String getScreen_newspapername() {
        return screen_newspapername;
    }

    public void setScreen_newspapername(String screen_newspapername) {
        this.screen_newspapername = screen_newspapername;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public LocalDateTime getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(LocalDateTime uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "DeviceInfoModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



}
