package ftn.sbnz.SBNZBackend.model;

import javax.persistence.*;

@Entity
@Table
public class Skor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private Integer budzet = 0;

    @Column(nullable = false)
    private Integer laptop = 0;

    @Column(nullable = false)
    private Integer prethodnoKoriscen = 0;

    @Column(nullable = false)
    private Integer cpuProizvodjac = 0;

    @Column(nullable = false)
    private Integer gpuProizvodjac = 0;

    @Column(nullable = false)
    private Integer jezgraCpu = 0;

    @Column(nullable = false)
    private Integer tredoviCpu = 0;

    @Column(nullable = false)
    private Integer brzinaCpu = 0;

    @Column(nullable = false)
    private Integer memorijaGpu = 0;

    @Column(nullable = false)
    private Integer tipMemorijeGpu = 0;

    @Column(nullable = false)
    private Integer memorijaRam = 0;

    @Column(nullable = false)
    private Integer tipMemorijeRam = 0;

    @Column(nullable = false)
    private Integer brzinaRam = 0;

    @Column(nullable = false)
    private Integer tipMemorijeHardDisk = 0;

    @Column(nullable = false)
    private Integer memorijaHardDisk = 0;

    @Column(nullable = false)
    private Integer suma = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBudzet() {
        return budzet;
    }

    public void setBudzet(Integer budzet) {
        this.budzet = budzet;
        this.suma += budzet;
    }

    public Integer getLaptop() {
        return laptop;
    }

    public void setLaptop(Integer laptop) {
        this.laptop = laptop;
        this.suma += laptop;
    }

    public Integer getPrethodnoKoriscen() {
        return prethodnoKoriscen;
    }

    public void setPrethodnoKoriscen(Integer prethodnoKoriscen) {
        this.prethodnoKoriscen = prethodnoKoriscen;
        this.suma += prethodnoKoriscen;
    }

    public Integer getCpuProizvodjac() {
        return cpuProizvodjac;
    }

    public void setCpuProizvodjac(Integer cpuProizvodjac) {
        this.cpuProizvodjac = cpuProizvodjac;
        this.suma += cpuProizvodjac;
    }

    public Integer getGpuProizvodjac() {
        return gpuProizvodjac;
    }

    public void setGpuProizvodjac(Integer gpuProizvodjac) {
        this.gpuProizvodjac = gpuProizvodjac;
        this.suma += gpuProizvodjac;
    }

    public Integer getJezgraCpu() {
        return jezgraCpu;
    }

    public void setJezgraCpu(Integer jezgraCpu) {
        this.jezgraCpu = jezgraCpu;
        this.suma += jezgraCpu;
    }

    public Integer getTredoviCpu() {
        return tredoviCpu;
    }

    public void setTredoviCpu(Integer tredoviCpu) {
        this.tredoviCpu = tredoviCpu;
        this.suma += tredoviCpu;
    }

    public Integer getBrzinaCpu() {
        return brzinaCpu;
    }

    public void setBrzinaCpu(Integer brzinaCpu) {
        this.brzinaCpu = brzinaCpu;
        this.suma += brzinaCpu;
    }

    public Integer getMemorijaGpu() {
        return memorijaGpu;
    }

    public void setMemorijaGpu(Integer memorijaGpu) {
        this.memorijaGpu = memorijaGpu;
        this.suma += memorijaGpu;
    }

    public Integer getTipMemorijeGpu() {
        return tipMemorijeGpu;
    }

    public void setTipMemorijeGpu(Integer tipMemorijeGpu) {
        this.tipMemorijeGpu = tipMemorijeGpu;
        this.suma += tipMemorijeGpu;
    }

    public Integer getMemorijaRam() {
        return memorijaRam;
    }

    public void setMemorijaRam(Integer memorijaRam) {
        this.memorijaRam = memorijaRam;
        this.suma += memorijaRam;
    }

    public Integer getTipMemorijeRam() {
        return tipMemorijeRam;
    }

    public void setTipMemorijeRam(Integer tipMemorijeRam) {
        this.tipMemorijeRam = tipMemorijeRam;
        this.suma += tipMemorijeRam;
    }

    public Integer getBrzinaRam() {
        return brzinaRam;
    }

    public void setBrzinaRam(Integer brzinaRam) {
        this.brzinaRam = brzinaRam;
        this.suma += brzinaRam;
    }

    public Integer getTipMemorijeHardDisk() {
        return tipMemorijeHardDisk;
    }

    public void setTipMemorijeHardDisk(Integer tipMemorijeHardDisk) {
        this.tipMemorijeHardDisk = tipMemorijeHardDisk;
        this.suma += tipMemorijeHardDisk;
    }

    public Integer getMemorijaHardDisk() {
        return memorijaHardDisk;
    }

    public void setMemorijaHardDisk(Integer memorijaHardDisk) {
        this.memorijaHardDisk = memorijaHardDisk;
        this.suma += memorijaHardDisk;
    }

    public Integer getSuma() {
        return suma;
    }

    public void setSuma(Integer suma) {
        this.suma = suma;
    }

    public Skor() {
    }

    public Skor(Integer budzet, Integer laptop, Integer prethodnoKoriscen, Integer cpuProizvodjac, Integer gpuProizvodjac, Integer jezgraCpu, Integer tredoviCpu, Integer brzinaCpu, Integer memorijaGpu, Integer tipMemorijeGpu, Integer memorijaRam, Integer tipMemorijeRam, Integer brzinaRam, Integer tipMemorijeHardDisk, Integer memorijaHardDisk, Integer suma) {
        this.budzet = budzet;
        this.laptop = laptop;
        this.prethodnoKoriscen = prethodnoKoriscen;
        this.cpuProizvodjac = cpuProizvodjac;
        this.gpuProizvodjac = gpuProizvodjac;
        this.jezgraCpu = jezgraCpu;
        this.tredoviCpu = tredoviCpu;
        this.brzinaCpu = brzinaCpu;
        this.memorijaGpu = memorijaGpu;
        this.tipMemorijeGpu = tipMemorijeGpu;
        this.memorijaRam = memorijaRam;
        this.tipMemorijeRam = tipMemorijeRam;
        this.brzinaRam = brzinaRam;
        this.tipMemorijeHardDisk = tipMemorijeHardDisk;
        this.memorijaHardDisk = memorijaHardDisk;
        this.suma = suma;
    }
}
