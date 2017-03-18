package com.network;

import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Georgi on 15.02.2017.
 */
public class ParserMethod {

    public static MyStruct getDateTime(int a, ArrayList<Integer> list) {

        MyStruct myStruct = new MyStruct();
        int []data = new int[4];

        switch (list.get(a)){
            case 0x6D:                                                                  //Время
                for(int i = 0;i<data.length;i++)   data[i]=list.get(++a);

                int nb1 = data[2];
                    nb1>>=5;
                int nb2 = data[3];
                    nb2&=0xF0;
                    nb2>>=1;
                nb2 += nb1;

                Calendar calendar = Calendar.getInstance();
                calendar.set(nb2+2000, (data[3]&0x0F)-1, data[2]&0x1F,data[1],data[0]);
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                myStruct.setStr(format.format(calendar.getTime()));
                myStruct.setCount(++a);
                break;
        }
        return myStruct;
    }

    public static MyStruct getErrorInInteger(int a, ArrayList<Integer> list) {

        MyStruct myStruct = new MyStruct();
        switch (list.get(a)){
            case 0x17:myStruct = ParserMethod.WordToInteger(++a, list);break;           //Ошибки общие
        }

        return myStruct;
    }

    public static MyStruct getPowFlowInFloat(int a, ArrayList<Integer> list){

        MyStruct myStruct = new MyStruct();
        switch (list.get(a)){
            case 0x2E:myStruct = ParserMethod.LongToFloat(++a, list);break;             //Тепловая мощность 1
            case 0x3E:myStruct = ParserMethod.LongToFloat(++a, list);break;             //Расход 1 в м3/ч
            case 0x56:myStruct = ParserMethod.LongToFloat(++a, list);break;             //Расход 1 в т/ч
        }
        return myStruct;
    }

    public static MyStruct getTemperInFloat(int a, ArrayList<Integer> list){

        MyStruct myStruct = new MyStruct();
        switch (list.get(a)){
            case 0x59:myStruct = ParserMethod.WordToFloat(++a, list, 0.01f);break;     //Температура 1 и 3 в гр.Ц
            case 0x5D:myStruct = ParserMethod.WordToFloat(++a, list, 0.01f);break;     //Температура 2 и 4 в гр.Ц
            case 0x65:myStruct = ParserMethod.WordToFloat(++a, list, 0.01f);break;     //Температура 5 в гр.Ц
        }
        return myStruct;
    }

    public static MyStruct getPressInFloat(int a, ArrayList<Integer> list){

        MyStruct myStruct = new MyStruct();
        switch (list.get(a)){
            case 0x68:myStruct = ParserMethod.Word3ToFloat(++a, list, 0.1f);break;     //Давление с 1 по 5 в кПа
        }
        return myStruct;
    }

    public static MyStruct getEVMTInFloat(int a, ArrayList<Integer> list){

        MyStruct myStruct = new MyStruct();

        switch (list.get(a)){
            case 0x07:                                                              //* 0.01 MWh
                myStruct = ParserMethod.LongToDouble(++a, list, 0.01f);break;
            case 0x06:                                                              //* 0.001 MWh
                myStruct = ParserMethod.LongToDouble(++a, list, 0.001f);break;
            case 0x16:                                                              //* 1.0 m3
                myStruct = ParserMethod.LongToDouble(++a, list, 1.0f);break;
            case 0x1E:                                                              //* 1.0 t
                myStruct = ParserMethod.LongToDouble(++a, list, 1.0f);break;
            case 0x15:                                                              //* 0.1 m3
                myStruct = ParserMethod.LongToDouble(++a, list, 0.1f);break;
            case 0x1D:                                                              //* 0.1 t
                myStruct = ParserMethod.LongToDouble(++a, list, 0.1f);break;
            case 0x14:                                                              //* 0.01 m3
                myStruct = ParserMethod.LongToDouble(++a, list, 0.01f);break;
            case 0x1C:                                                              //* 0.01 t
                myStruct = ParserMethod.LongToDouble(++a, list, 0.01f);break;
            case 0x13:                                                              //* 0.001 m3
                myStruct = ParserMethod.LongToDouble(++a, list, 0.001f);break;
            case 0x1B:                                                              //* 0.001 t
                myStruct = ParserMethod.LongToDouble(++a, list, 0.001f);break;
            case 0x20:                                                              //Время работы при вкл питании в сек
                myStruct = ParserMethod.LongToDouble(++a, list, 1.0f);break;
            case 0x24:                                                              //Время работы 1 сист в норм режиме в сек
                myStruct = ParserMethod.LongToDouble(++a, list, 1.0f);break;

            case 0x68:                                                              //Давление в кПа
                myStruct = ParserMethod.LongToDouble(++a, list, 0.1f);break;

        }
        return myStruct;
    }

    public static MyStruct LongToDouble(int a, ArrayList<Integer> list, float factor){

        long amount = 0;
        MyStruct myStruct = new MyStruct();
        myStruct.setCount(a);
        myStruct.setErr(0);

        for(int i=0;i<32;i+=8){
            amount += list.get(myStruct.getCount()) << i;
            myStruct.setCount(++a);
        }
        myStruct.setParam((double)amount*factor);

        return myStruct;
    }

    public static MyStruct LongToFloat(int a, ArrayList<Integer> list){

        MyStruct myStruct = new MyStruct();
        myStruct.setCount(a);
        myStruct.setErr(0);

        byte[] b = new byte[4];
        for(int i=3;i>=0;i--){
            int y =  list.get(myStruct.getCount());
            b[i] = (byte) y;
            myStruct.setCount(++a);
        }
        myStruct.setParam((double)ByteBuffer.wrap(b).getFloat());

        return myStruct;
    }

    public static MyStruct WordToFloat(int a, ArrayList<Integer> list, float factor){

        float amount = 0;
        MyStruct myStruct = new MyStruct();
        myStruct.setCount(a);
        myStruct.setErr(0);

        for(int i=0;i<16;i+=8){
            amount += list.get(myStruct.getCount()) << i;
            myStruct.setCount(++a);
        }
        myStruct.setParam((double) amount*factor);

        return myStruct;
    }

    public static MyStruct Word3ToFloat(int a, ArrayList<Integer> list, float factor){

        float amount = 0;
        MyStruct myStruct = new MyStruct();
        myStruct.setCount(a);
        myStruct.setErr(0);

        for(int i=0;i<24;i+=8){
            amount += list.get(myStruct.getCount()) << i;
            myStruct.setCount(++a);
        }
        myStruct.setParam((double) amount*factor);

        return myStruct;
    }

    public static MyStruct WordToInteger(int a, ArrayList<Integer> list){

        int amount = 0;
        MyStruct myStruct = new MyStruct();
        myStruct.setCount(a);
        myStruct.setParam(0.0);

        for(int i=0;i<16;i+=8){
            amount += list.get(myStruct.getCount()) << i;
            myStruct.setCount(++a);
        }
        myStruct.setErr(amount);

        return myStruct;
    }
}
