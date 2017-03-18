package com.network;

import com.base.Model.DataDay;
import com.base.Model.DataHour;
import com.base.Model.Device;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Georgi on 15.02.2017.
 */
public class DataParser {

    private static final Logger log = Logger.getLogger(DataParser.class);
    public static DataDay MyParserDataDay (Device device, ArrayList<Integer> list, int j){

        DataDay dataDay = new DataDay();
        MyStruct myStruct;
        int a;

        for(a = j; a<list.size()-2;){

            switch (list.get(a)){
                case 0x04: {
                    if(list.get(a+1).equals(0x6D)){                                 //Это дата и время
                        myStruct = ParserMethod.getDateTime(++a, list);
                        dataDay.setDateTime(myStruct.getStr());
                        a = myStruct.getCount();
                    }
                    else if (list.get(a+1).equals(0x20)){                           //Общее время работы
                        myStruct = ParserMethod.getEVMTInFloat(++a, list);          //в часах при вкл питании
                        dataDay.setFullTimeGeneral(myStruct.getParam()/3600);
                        a = myStruct.getCount();
                    }
                    else if(list.get(a+1).equals(0x24)){                            //Общее время работы
                        myStruct = ParserMethod.getEVMTInFloat(++a, list);          //в норм режиме
                        dataDay.setFullTimeNorm(myStruct.getParam()/3600);
                        a = myStruct.getCount();
                    }
                    else if(list.get(a+1).equals(0x07) ||list.get(a+1).equals(0x06)){   //Энергия Е1
                        myStruct = ParserMethod.getEVMTInFloat(++a, list);
                        dataDay.setEnergy1(myStruct.getParam());
                        a = myStruct.getCount();
                    }
                    else if(list.get(a+1).equals(0x16) || list.get(a+1).equals(0x15) || //Объем 1
                            list.get(a+1).equals(0x14) || list.get(a+1).equals(0x13)){
                        myStruct = ParserMethod.getEVMTInFloat(++a, list);
                        dataDay.setVolume1(myStruct.getParam());
                        a = myStruct.getCount();
                    }
                    else if(list.get(a+1).equals(0x1E) || list.get(a+1).equals(0x1D) ||
                            list.get(a+1).equals(0x1C) || list.get(a+1).equals(0x1B)){
                        myStruct = ParserMethod.getEVMTInFloat(++a, list);              //Масса 1
                        dataDay.setMass1(myStruct.getParam());
                        a = myStruct.getCount();
                    }
                    else a = list.size();
                }
                break;
                case 0x84:{
                    switch (list.get(++a)){
                        case 0x40:{
                            myStruct = ParserMethod.getEVMTInFloat(++a, list);

                            if(list.get(a).equals(0x24)){                            //Общее время работы
                                dataDay.setFullTimeNormOne(myStruct.getParam()/3600);//системы 1 в норм режиме
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0x07) ||list.get(a).equals(0x06)){   //Энергия Е2
                                dataDay.setEnergy2(myStruct.getParam());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0x16) || list.get(a).equals(0x15) || //Объем 2
                                    list.get(a).equals(0x14) || list.get(a).equals(0x13)){
                                dataDay.setVolume2(myStruct.getParam());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a+1).equals(0x1E) || list.get(a+1).equals(0x1D) ||
                                        list.get(a+1).equals(0x1C) || list.get(a+1).equals(0x1B)){                                                              //Масса 2
                                dataDay.setMass2(myStruct.getParam());
                                a = myStruct.getCount();
                            }
                            else a = list.size();
                        }
                        break;
                        case 0x80:{
                            switch (list.get(++a)){
                                case 0x40:{
                                    myStruct = ParserMethod.getEVMTInFloat(++a, list);

                                    if(list.get(a).equals(0x24)){                            //Общее время работы
                                        dataDay.setFullTimeNormTwo(myStruct.getParam()/3600);//системы 2 в норм режиме
                                        a = myStruct.getCount();
                                    }
                                    else if(list.get(a).equals(0x07) ||list.get(a).equals(0x06)){   //Энергия Е3
                                        dataDay.setEnergy3(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else if(list.get(a).equals(0x16) || list.get(a).equals(0x15) || //Объем реверс
                                            list.get(a).equals(0x14) || list.get(a).equals(0x13)){
                                        dataDay.setVolumeR(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else if(list.get(a).equals(0x1E) || list.get(a).equals(0x1D) ||
                                            list.get(a).equals(0x1C) || list.get(a).equals(0x1B)){                                                               //Масса реверс
                                        dataDay.setMassR(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else a = list.size();
                                }break;
                                case 0x80:{
                                    switch (list.get(++a)){
                                        case 0x40:{
                                            myStruct = ParserMethod.getEVMTInFloat(++a, list);

                                            if(list.get(a).equals(0x16) || list.get(a).equals(0x15) || //Объем 4
                                                    list.get(a).equals(0x14) || list.get(a).equals(0x13)){
                                                dataDay.setVolume4(myStruct.getParam());
                                                a = myStruct.getCount();
                                            }
                                            else if(list.get(a).equals(0x1E) || list.get(a).equals(0x1D) ||
                                                    list.get(a).equals(0x1C) || list.get(a).equals(0x1B)){                                                            //Масса 4
                                                dataDay.setMass4(myStruct.getParam());
                                                a = myStruct.getCount();
                                            }
                                            else a = list.size();
                                        }break;
                                    }
                                }break;
                            }
                        }
                        break;
                        case 0xC0:{
                            switch (list.get(++a)){
                                case 0x40:{
                                    myStruct = ParserMethod.getEVMTInFloat(++a, list);

                                    if(list.get(a).equals(0x16) || list.get(a).equals(0x15) || //Объем 3
                                            list.get(a).equals(0x14) || list.get(a).equals(0x13)){
                                        dataDay.setVolume3(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else if(list.get(a).equals(0x1E) || list.get(a).equals(0x1D) ||
                                            list.get(a).equals(0x1C) || list.get(a).equals(0x1B)){//Масса 3
                                        dataDay.setMass3(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else a = list.size();
                                }break;
                                case 0x80:{
                                    switch (list.get(++a)){
                                        case 0x40:{
                                            myStruct = ParserMethod.getEVMTInFloat(++a, list);

                                            if(list.get(a).equals(0x16) || list.get(a).equals(0x15) || //Объем 5
                                                    list.get(a).equals(0x14) || list.get(a).equals(0x13)){
                                                dataDay.setVolume5(myStruct.getParam());
                                                a = myStruct.getCount();
                                            }
                                            else if(list.get(a).equals(0x1E) || list.get(a).equals(0x1D) ||
                                                    list.get(a).equals(0x1C) || list.get(a).equals(0x1B)){//Масса 5
                                                dataDay.setMass5(myStruct.getParam());
                                                a = myStruct.getCount();
                                            }
                                            else a = list.size();
                                        }break;
                                    }
                                }break;
                            }
                        }
                        break;
                    }
                }
                break;
                case 0x05:{
                    myStruct = ParserMethod.getPowFlowInFloat(++a,list);
                    if(list.get(a).equals(0x2E)) {
                        dataDay.setPower1(myStruct.getParam());
                        a = myStruct.getCount();
                    }
                    else if(list.get(a).equals(0x3E)){
                        dataDay.setFlowV1(myStruct.getParam());
                        a = myStruct.getCount();
                    }
                    else if(list.get(a).equals(0x56)){
                        dataDay.setFlowM1(myStruct.getParam());
                        a = myStruct.getCount();
                    }
                    else a = list.size();
                }
                break;
                case 0x85:
                    switch (list.get(++a)){
                        case 0x40:
                            myStruct = ParserMethod.getPowFlowInFloat(++a,list);
                            if(list.get(a).equals(0x2E)) {
                                dataDay.setPower2(myStruct.getParam());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0x3E)){
                                dataDay.setFlowV2(myStruct.getParam());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0x56)){
                                dataDay.setFlowM2(myStruct.getParam());
                                a = myStruct.getCount();
                            }
                            else a = list.size();
                            break;
                        case 0x80:
                            switch (list.get(++a)){
                                case 0x40:
                                    myStruct = ParserMethod.getPowFlowInFloat(++a,list);
                                    if(list.get(a).equals(0x2E)) {
                                        dataDay.setPower3(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else if(list.get(a).equals(0x3E)){
                                        dataDay.setFlowV3(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else if(list.get(a).equals(0x56)){
                                        dataDay.setFlowM3(myStruct.getParam());
                                        a = myStruct.getCount();
                                    }
                                    else a = list.size();
                                    break;
                                case 0x80:
                                    switch (list.get(++a)){
                                        case 0x40:
                                            myStruct = ParserMethod.getPowFlowInFloat(++a,list);

                                            if(list.get(a).equals(0x3E)){
                                            dataDay.setFlowV5(myStruct.getParam());
                                            a = myStruct.getCount();
                                        }
                                        else if(list.get(a).equals(0x56)){
                                            dataDay.setFlowM5(myStruct.getParam());
                                            a = myStruct.getCount();
                                        }
                                            else a = list.size();
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 0xC0:
                            switch (list.get(++a)){
                                case 0x40:
                                    myStruct = ParserMethod.getPowFlowInFloat(++a,list);

                                    if(list.get(a).equals(0x3E)){
                                    dataDay.setFlowV4(myStruct.getParam());
                                    a = myStruct.getCount();
                                }
                                else if(list.get(a).equals(0x56)){
                                    dataDay.setFlowM4(myStruct.getParam());
                                    a = myStruct.getCount();
                                }
                                    else a = list.size();
                                    break;
                            }
                            break;
                    }
                    break;
                case 0x02: {a++;
                    if (list.get(a).equals(0x59)) {                                //Температура 1
                        myStruct = ParserMethod.getTemperInFloat(a, list);
                        dataDay.setTemper1(myStruct.getParam().floatValue());
                        a = myStruct.getCount();
                    } else if (list.get(a).equals(0x5D)) {                           //Температура 2
                        myStruct = ParserMethod.getTemperInFloat(a, list);
                        dataDay.setTemper2(myStruct.getParam().floatValue());
                        a = myStruct.getCount();
                    } else if (list.get(a).equals(0x65)) {                           //Температура 5
                        myStruct = ParserMethod.getTemperInFloat(a, list);
                        dataDay.setTemper5(myStruct.getParam().floatValue());
                        a = myStruct.getCount();
                    }else if (list.get(a).equals(0xFD)) {                           //Ошибки общие
                            a++;
                        if(list.get(a).equals(0x17)){
                            myStruct = ParserMethod.getErrorInInteger(a, list);
                            dataDay.setErrorFull(myStruct.getErr());
                            a = myStruct.getCount();
                        }
                        else a = list.size();
                    }
                    else a = list.size();
                }
                    break;
                case 0x82:
                    switch (list.get(++a)){
                        case 0x40:
                            a++;
                            if(list.get(a).equals(0x65)){                            //Температура 6
                                myStruct = ParserMethod.getTemperInFloat(a, list);
                                dataDay.setTemper6(myStruct.getParam().floatValue());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0x59)){                        //Температура 3
                                myStruct = ParserMethod.getTemperInFloat(a, list);
                                dataDay.setTemper3(myStruct.getParam().floatValue());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0x5D)){                   //Температура 4
                                myStruct = ParserMethod.getTemperInFloat(a, list);
                                dataDay.setTemper4(myStruct.getParam().floatValue());
                                a = myStruct.getCount();
                            }
                            else if(list.get(a).equals(0xFD)){                   //Ошибки расхода
                                a++;
                                if(list.get(a).equals(0x17)){
                                    myStruct = ParserMethod.getErrorInInteger(a, list);
                                    dataDay.setErrorFlow(myStruct.getErr());
                                    a = myStruct.getCount();
                                }
                                else a = list.size();
                            }
                            else a = list.size();
                            break;
                        case 0x80:
                            switch (list.get(++a)){
                                case 0x40:
                                    if(list.get(++a).equals(0xFD)){               //Ошибки температуры
                                        a++;
                                        if(list.get(a).equals(0x17)){
                                            myStruct = ParserMethod.getErrorInInteger(a, list);
                                            dataDay.setErrorTemper(myStruct.getErr());
                                            a = myStruct.getCount();
                                        }
                                        else a = list.size();
                                    }
                                    else  a = list.size();
                                    break;
                            }
                            break;
                    }
                    break;
                case 0x03:
                    myStruct = ParserMethod.getPressInFloat(++a, list);

                    if(list.get(a).equals(0x68)){                                 //Давление 1
                        dataDay.setPressure1(myStruct.getParam().floatValue());
                        a = myStruct.getCount();
                    }
                    else a = list.size();
                    break;
                case 0x83:
                    switch (list.get(++a)){
                        case 0x40:
                            myStruct = ParserMethod.getPressInFloat(++a, list);

                            if(list.get(a).equals(0x68)){                        //Давление 2
                                dataDay.setPressure2(myStruct.getParam().floatValue());
                                a = myStruct.getCount();
                            }
                            else a = list.size();
                            break;
                        case 0x80:
                            switch (list.get(++a)){
                                case 0x40:
                                    myStruct = ParserMethod.getPressInFloat(++a, list);

                                    if(list.get(a).equals(0x68)){                        //Давление 3
                                        dataDay.setPressure3(myStruct.getParam().floatValue());
                                        a = myStruct.getCount();
                                    }
                                    else a = list.size();
                                    break;
                                case 0x80:
                                    switch (list.get(++a)){
                                        case 0x40:
                                            myStruct = ParserMethod.getPressInFloat(++a, list);

                                            if(list.get(a).equals(0x68)){                        //Давление 5
                                                dataDay.setPressure5(myStruct.getParam().floatValue());
                                                a = myStruct.getCount();
                                            }
                                            else a = list.size();
                                            break;
                                    }
                                    break;
                            }
                            break;
                        case 0xC0:
                            switch (list.get(++a)){
                                case 0x40:
                                    myStruct = ParserMethod.getPressInFloat(++a, list);

                                    if(list.get(a).equals(0x68)){                        //Давление 4
                                        dataDay.setPressure4(myStruct.getParam().floatValue());
                                        a = myStruct.getCount();
                                    }
                                    else a = list.size();
                                    break;
                                case 0x80:
                                    switch (list.get(++a)){
                                        case 0x40:
                                            myStruct = ParserMethod.getPressInFloat(++a, list);

                                            if(list.get(a).equals(0x68)){                        //Давление 6
                                                dataDay.setPressure6(myStruct.getParam().floatValue());
                                                a = myStruct.getCount();
                                            }
                                            else a = list.size();
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        if(a == list.size()) {
            log.error("ERROR Parsing data with IP = "+device.getIp().getIpName()+" !");
            return null;
        }
        else{log.info("OK Parsing data with IP = "+device.getIp().getIpName()+" !");}

        dataDay.setDevice(device);

        return dataDay;
    }

    public static DataHour MyParserDataHour (Device device, ArrayList<Integer> list){
        return null;
    }
}
