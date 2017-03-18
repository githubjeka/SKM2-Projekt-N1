package com.base.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*

Дневные данные одного счетчика
 */
@Entity
@Table(name = "DAY_TABLE", catalog = "skm2_model_2")
public class DataDay implements Serializable {

    private Integer day_Id;
    private Device device;

    private String dateTime;

    private Double power1;
    private Double power2;
    private Double power3;
    private Double energy1;
    private Double energy2;
    private Double energy3;

    private Double flowV1;
    private Double flowV2;
    private Double flowV3;
    private Double flowV4;
    private Double flowV5;

    private Double flowM1;
    private Double flowM2;
    private Double flowM3;
    private Double flowM4;
    private Double flowM5;

    private Double volume1;
    private Double volume2;
    private Double volumeR;
    private Double volume3;
    private Double volume4;
    private Double volume5;

    private Double mass1;
    private Double mass2;
    private Double massR;
    private Double mass3;
    private Double mass4;
    private Double mass5;

    private Float temper1;
    private Float temper2;
    private Float temper3;
    private Float temper4;
    private Float temper5;
    private Float temper6;

    private Float pressure1;
    private Float pressure2;
    private Float pressure3;
    private Float pressure4;
    private Float pressure5;
    private Float pressure6;

    private Double fullTimeGeneral;
    private Double fullTimeNorm;
    private Double fullTimeNormOne;
    private Double fullTimeNormTwo;

    private int errorFull;
    private int errorFlow;
    private int errorTemper;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DAY", nullable = false)
    public Integer getDay_Id() {
        return day_Id;
    }
    public void setDay_Id(Integer day_Id) {
        this.day_Id = day_Id;
    }

    @Column(name = "DATE", nullable = false, unique = true)
    public String getDateTime() {return dateTime;}
    public void setDateTime(String dataTime) {this.dateTime = dataTime;}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DEVICE", referencedColumnName = "ID_DEVICE", nullable = false)
    public Device getDevice() {return device;}
    public void setDevice(Device device) {this.device = device;}

    @Column(name = "POWER1")
    public Double getPower1() {return power1;}
    public void setPower1(Double power1) {this.power1 = power1;}

    @Column(name = "POWER2")
    public Double getPower2() {return power2;}
    public void setPower2(Double power2) {this.power2 = power2;}

    @Column(name = "POWER3")
    public Double getPower3() {return power3;}
    public void setPower3(Double power3) {this.power3 = power3;}

    @Column(name = "ENERGY1")
    public Double getEnergy1() {return energy1;}
    public void setEnergy1(Double energy1) {this.energy1 = energy1;}

    @Column(name = "ENERGY2")
    public Double getEnergy2() {return energy2;}
    public void setEnergy2(Double energy2) {this.energy2 = energy2;}

    @Column(name = "ENERGY3")
    public Double getEnergy3() {return energy3;}
    public void setEnergy3(Double energy3) {this.energy3 = energy3;}

    @Column(name = "FLOW_V1")
    public Double getFlowV1() {return flowV1;}
    public void setFlowV1(Double flowV1) {this.flowV1 = flowV1;}

    @Column(name = "FLOW_V2")
    public Double getFlowV2() {return flowV2;}
    public void setFlowV2(Double flowV2) {this.flowV2 = flowV2;}

    @Column(name = "FLOW_V3")
    public Double getFlowV3() {return flowV3;}
    public void setFlowV3(Double flowV3) {this.flowV3 = flowV3;}

    @Column(name = "FLOW_V4")
    public Double getFlowV4() {return flowV4;}
    public void setFlowV4(Double flowV4) {this.flowV4 = flowV4;}

    @Column(name = "FLOW_V5")
    public Double getFlowV5() {return flowV5;}
    public void setFlowV5(Double flowV5) {this.flowV5 = flowV5;}

    @Column(name = "FLOW_M1")
    public Double getFlowM1() {return flowM1;}
    public void setFlowM1(Double flowM1) {this.flowM1 = flowM1;}

    @Column(name = "FLOW_M2")
    public Double getFlowM2() {return flowM2;}
    public void setFlowM2(Double flowM2) {this.flowM2 = flowM2;}

    @Column(name = "FLOW_M3")
    public Double getFlowM3() {return flowM3;}
    public void setFlowM3(Double flowM3) {this.flowM3 = flowM3;}

    @Column(name = "FLOW_M4")
    public Double getFlowM4() {return flowM4;}
    public void setFlowM4(Double flowM4) {this.flowM4 = flowM4;}

    @Column(name = "FLOW_M5")
    public Double getFlowM5() {return flowM5;}
    public void setFlowM5(Double flowM5) {this.flowM5 = flowM5;}

    @Column(name = "VOLUME1")
    public Double getVolume1() {
        return volume1;
    }
    public void setVolume1(Double volume1) {
        this.volume1 = volume1;
    }

    @Column(name = "VOLUME2")
    public Double getVolume2() {
        return volume2;
    }
    public void setVolume2(Double volume2) {
        this.volume2 = volume2;
    }

    @Column(name = "VOLUMER")
    public Double getVolumeR() {
        return volumeR;
    }
    public void setVolumeR(Double volumeR) {
        this.volumeR = volumeR;
    }

    @Column(name = "VOLUME3")
    public Double getVolume3() {
        return volume3;
    }
    public void setVolume3(Double volume3) {
        this.volume3 = volume3;
    }

    @Column(name = "VOLUME4")
    public Double getVolume4() {
        return volume4;
    }
    public void setVolume4(Double volume4) {
        this.volume4 = volume4;
    }

    @Column(name = "VOLUME5")
    public Double getVolume5() {
        return volume5;
    }
    public void setVolume5(Double volume5) {
        this.volume5 = volume5;
    }

    @Column(name = "MASS1")
    public Double getMass1() {return mass1;}
    public void setMass1(Double mass1) {this.mass1 = mass1;}

    @Column(name = "MASS2")
    public Double getMass2() {return mass2;}
    public void setMass2(Double mass2) {this.mass2 = mass2;}

    @Column(name = "MASSR")
    public Double getMassR() {return massR;}
    public void setMassR(Double massR) {this.massR = massR;}

    @Column(name = "MASS3")
    public Double getMass3() {return mass3;}
    public void setMass3(Double mass3) {this.mass3 = mass3;}

    @Column(name = "MASS4")
    public Double getMass4() {return mass4;}
    public void setMass4(Double mass4) {this.mass4 = mass4;}

    @Column(name = "MASS5")
    public Double getMass5() {return mass5;}
    public void setMass5(Double mass5) {this.mass5 = mass5;}

    @Column(name = "TEMPER1")
    public Float getTemper1() {
        return temper1;
    }
    public void setTemper1(Float temper1) {
        this.temper1 = temper1;
    }

    @Column(name = "TEMPER2")
    public Float getTemper2() {
        return temper2;
    }
    public void setTemper2(Float temper2) {
        this.temper2 = temper2;
    }

    @Column(name = "TEMPER3")
    public Float getTemper3() {
        return temper3;
    }
    public void setTemper3(Float temper3) {
        this.temper3 = temper3;
    }

    @Column(name = "TEMPER4")
    public Float getTemper4() {
        return temper4;
    }
    public void setTemper4(Float temper4) {
        this.temper4 = temper4;
    }

    @Column(name = "TEMPER5")
    public Float getTemper5() {
        return temper5;
    }
    public void setTemper5(Float temper5) {
        this.temper5 = temper5;
    }

    @Column(name = "TEMPER6")
    public Float getTemper6() {
        return temper6;
    }
    public void setTemper6(Float temper6) {
        this.temper6 = temper6;
    }


    @Column(name = "PRESS1")
    public Float getPressure1() {
        return pressure1;
    }
    public void setPressure1(Float pressure1) {
        this.pressure1 = pressure1;
    }

    @Column(name = "PRESS2")
    public Float getPressure2() {
        return pressure2;
    }
    public void setPressure2(Float pressure2) {
        this.pressure2 = pressure2;
    }

    @Column(name = "PRESS3")
    public Float getPressure3() {
        return pressure3;
    }
    public void setPressure3(Float pressure3) {
        this.pressure3 = pressure3;
    }

    @Column(name = "PRESS4")
    public Float getPressure4() {
        return pressure4;
    }
    public void setPressure4(Float pressure4) {
        this.pressure4 = pressure4;
    }

    @Column(name = "PRESS5")
    public Float getPressure5() {
        return pressure5;
    }
    public void setPressure5(Float pressure5) {
        this.pressure5 = pressure5;
    }

    @Column(name = "PRESS6")
    public Float getPressure6() {
        return pressure6;
    }
    public void setPressure6(Float pressure6) {
        this.pressure6 = pressure6;
    }

    @Column(name = "TIMEGEN")
    public Double getFullTimeGeneral() {return fullTimeGeneral;}
    public void setFullTimeGeneral(Double fullTimeGeneral) {this.fullTimeGeneral = fullTimeGeneral;}

    @Column(name = "TIMENORM")
    public Double getFullTimeNorm() {return fullTimeNorm;}
    public void setFullTimeNorm(Double fullTimeNorm) {this.fullTimeNorm = fullTimeNorm;}

    @Column(name = "TIMENORM_1")
    public Double getFullTimeNormOne() {return fullTimeNormOne;}
    public void setFullTimeNormOne(Double fullTimeNormOne) {this.fullTimeNormOne = fullTimeNormOne;}

    @Column(name = "TIMENORM_2")
    public Double getFullTimeNormTwo() {return fullTimeNormTwo;}
    public void setFullTimeNormTwo(Double fullTimeNormTwo) {this.fullTimeNormTwo = fullTimeNormTwo;}

    @Column(name = "ER_FULL")
    public int getErrorFull() {return errorFull;}
    public void setErrorFull(int errorFull) {this.errorFull = errorFull;}

    @Column(name = "ER_FLOW")
    public int getErrorFlow() {return errorFlow;}
    public void setErrorFlow(int errorFlow) {this.errorFlow = errorFlow;}

    @Column(name = "ER_TEMP")
    public int getErrorTemper() {return errorTemper;}
    public void setErrorTemper(int errorTemper) {this.errorTemper = errorTemper;}

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NUMBER", referencedColumnName = "ID_NUMBER", nullable = false)
    public Device getDevice() {return device;}
    public void setDevice(Device device) {this.device = device;}*/

    @Override
    public String toString() {
        return "DataDay{" +
                "day_Id=" + day_Id +
                ", \n device=" + device +
                ", \n dateTime='" + dateTime + '\'' +
                ", \n power1=" + power1 +
                ", \n power2=" + power2 +
                ", \n power3=" + power3 +
                ", \n energy1=" + energy1 +
                ", \n energy2=" + energy2 +
                ", \n energy3=" + energy3 +
                ", \n flowV1=" + flowV1 +
                ", \n flowV2=" + flowV2 +
                ", \n flowV3=" + flowV3 +
                ", \n flowV4=" + flowV4 +
                ", \n flowV5=" + flowV5 +
                ", \n flowM1=" + flowM1 +
                ", \n flowM2=" + flowM2 +
                ", \n flowM3=" + flowM3 +
                ", \n flowM4=" + flowM4 +
                ", \n flowM5=" + flowM5 +
                ", \n volume1=" + volume1 +
                ", \n volume2=" + volume2 +
                ", \n volumeR=" + volumeR +
                ", \n volume3=" + volume3 +
                ", \n volume4=" + volume4 +
                ", \n volume5=" + volume5 +
                ", \n mass1=" + mass1 +
                ", \n mass2=" + mass2 +
                ", \n massR=" + massR +
                ", \n mass3=" + mass3 +
                ", \n mass4=" + mass4 +
                ", \n mass5=" + mass5 +
                ", \n temper1=" + temper1 +
                ", \n temper2=" + temper2 +
                ", \n temper3=" + temper3 +
                ", \n temper4=" + temper4 +
                ", \n temper5=" + temper5 +
                ", \n temper6=" + temper6 +
                ", \n pressure1=" + pressure1 +
                ", \n pressure2=" + pressure2 +
                ", \n pressure3=" + pressure3 +
                ", \n pressure4=" + pressure4 +
                ", \n pressure5=" + pressure5 +
                ", \n pressure6=" + pressure6 +
                ", \n fullTimeGeneral=" + fullTimeGeneral +
                ", \n fullTimeNorm=" + fullTimeNorm +
                ", \n fullTimeNormOne=" + fullTimeNormOne +
                ", \n fullTimeNormTwo=" + fullTimeNormTwo +
                ", \n errorFull=" + errorFull +
                ", \n errorFlow=" + errorFlow +
                ", \n errorTemper=" + errorTemper +
                '}';
    }
}
