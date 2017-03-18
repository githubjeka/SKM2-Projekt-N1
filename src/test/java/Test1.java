import com.base.Model.DataDay;
import com.base.Model.Device;
import com.network.DataParser;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Georgi on 15.02.2017.
 */
public class Test1 {
    @Test
    public void testDataDevice(){

        Device device =new Device();
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(104);
        list.add(218);
        list.add(218);
        list.add(104);
        list.add(8);
        list.add(1);
        list.add(114);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(4);
        list.add(4);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(4);
        list.add(109);
        list.add(48);
        list.add(22);
        list.add(48);
        list.add(34);
        list.add(4);
        list.add(6);
        list.add(131);
        list.add(5);
        list.add(0);
        list.add(0);
        list.add(4);
        list.add(19);
        list.add(236);
        list.add(99);
        list.add(0);
        list.add(0);
        list.add(132);
        list.add(64);
        list.add(19);
        list.add(236);
        list.add(99);
        list.add(0);
        list.add(0);
        list.add(132);
        list.add(192);
        list.add(64);
        list.add(19);
        list.add(236);
        list.add(99);
        list.add(0);
        list.add(0);
        list.add(132);
        list.add(128);
        list.add(128);
        list.add(64);
        list.add(19);
        list.add(236);
        list.add(99);
        list.add(0);
        list.add(0);
        list.add(132);
        list.add(192);
        list.add(128);
        list.add(64);
        list.add(19);
        list.add(236);
        list.add(99);
        list.add(0);
        list.add(0);
        list.add(5);
        list.add(46);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(5);
        list.add(62);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(133);
        list.add(64);
        list.add(62);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(133);
        list.add(128);
        list.add(64);
        list.add(62);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(133);
        list.add(192);
        list.add(64);
        list.add(62);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(133);
        list.add(128);
        list.add(128);
        list.add(64);
        list.add(62);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(2);
        list.add(89);
        list.add(80);
        list.add(70);
        list.add(2);
        list.add(93);
        list.add(210);
        list.add(35);
        list.add(130);
        list.add(64);
        list.add(89);
        list.add(80);
        list.add(70);
        list.add(130);
        list.add(64);
        list.add(93);
        list.add(80);
        list.add(70);
        list.add(2);
        list.add(101);
        list.add(80);
        list.add(70);
        list.add(130);
        list.add(64);
        list.add(101);
        list.add(80);
        list.add(70);
        list.add(3);
        list.add(104);
        list.add(112);
        list.add(23);
        list.add(0);
        list.add(131);
        list.add(64);
        list.add(104);
        list.add(160);
        list.add(15);
        list.add(0);
        list.add(131);
        list.add(128);
        list.add(64);
        list.add(104);
        list.add(112);
        list.add(23);
        list.add(0);
        list.add(131);
        list.add(192);
        list.add(64);
        list.add(104);
        list.add(160);
        list.add(15);
        list.add(0);
        list.add(131);
        list.add(128);
        list.add(128);
        list.add(64);
        list.add(104);
        list.add(160);
        list.add(15);
        list.add(0);
        list.add(131);
        list.add(192);
        list.add(128);
        list.add(64);
        list.add(104);
        list.add(160);
        list.add(15);
        list.add(0);
        list.add(130);
        list.add(64);
        list.add(253);
        list.add(23);
        list.add(0);
        list.add(0);
        list.add(130);
        list.add(128);
        list.add(64);
        list.add(253);
        list.add(23);
        list.add(4);
        list.add(73);
        list.add(4);
        list.add(32);
        list.add(104);
        list.add(206);
        list.add(5);
        list.add(0);
        list.add(4);
        list.add(36);
        list.add(224);
        list.add(159);
        list.add(0);
        list.add(0);
        list.add(132);
        list.add(64);
        list.add(36);
        list.add(248);
        list.add(159);
        list.add(0);
        list.add(0);
        list.add(132);
        list.add(128);
        list.add(64);
        list.add(36);
        list.add(48);
        list.add(161);
        list.add(0);
        list.add(0);
        list.add(6);
        list.add(22);

        DataDay dataDay = DataParser.MyParserDataDay(device, list,19);

        System.out.println("Data         = "+ dataDay.getDateTime());
        System.out.println("Power1       = "+ dataDay.getPower1());
        System.out.println("Power2       = "+ dataDay.getPower2());
        System.out.println("Power3       = "+ dataDay.getPower3());
        System.out.println("Energy1      = "+ dataDay.getEnergy1());
        System.out.println("Energy2      = "+ dataDay.getEnergy2());
        System.out.println("Energy3      = "+ dataDay.getEnergy3());
        System.out.println("FlowV1       = "+ dataDay.getFlowV1());
        System.out.println("FlowV2       = "+ dataDay.getFlowV2());
        System.out.println("FlowV3       = "+ dataDay.getFlowV3());
        System.out.println("FlowV4       = "+ dataDay.getFlowV4());
        System.out.println("FlowV5       = "+ dataDay.getFlowV5());
        System.out.println("FlowM1       = "+ dataDay.getFlowM1());
        System.out.println("FlowM2       = "+ dataDay.getFlowM2());
        System.out.println("FlowM3       = "+ dataDay.getFlowM3());
        System.out.println("FlowM4       = "+ dataDay.getFlowM4());
        System.out.println("FlowM5       = "+ dataDay.getFlowM5());
        System.out.println("Volume1      = "+ dataDay.getVolume1());
        System.out.println("Volume2      = "+ dataDay.getVolume2());
        System.out.println("Volume3      = "+ dataDay.getVolume3());
        System.out.println("Volume4      = "+ dataDay.getVolume4());
        System.out.println("Volume5      = "+ dataDay.getVolume5());
        System.out.println("Mass1        = "+ dataDay.getMass1());
        System.out.println("Mass2        = "+ dataDay.getMass2());
        System.out.println("Mass3        = "+ dataDay.getMass3());
        System.out.println("Mass4        = "+ dataDay.getMass4());
        System.out.println("Mass5        = "+ dataDay.getMass5());
        System.out.println("Temperature1 = "+ dataDay.getTemper1());
        System.out.println("Temperature2 = "+ dataDay.getTemper2());
        System.out.println("Temperature3 = "+ dataDay.getTemper3());
        System.out.println("Temperature4 = "+ dataDay.getTemper4());
        System.out.println("Temperature5 = "+ dataDay.getTemper5());
        System.out.println("Temperature6 = "+ dataDay.getTemper6());
        System.out.println("Pressure1    = "+ dataDay.getPressure1());
        System.out.println("Pressure2    = "+ dataDay.getPressure2());
        System.out.println("Pressure3    = "+ dataDay.getPressure3());
        System.out.println("Pressure4    = "+ dataDay.getPressure4());
        System.out.println("Pressure5    = "+ dataDay.getPressure5());
        System.out.println("Pressure6    = "+ dataDay.getPressure6()+"\n");

        System.out.println("Time full   = "+ dataDay.getFullTimeGeneral());
        System.out.println("Time Norm F = "+ dataDay.getFullTimeNorm());
        System.out.println("Time Norm 1 = "+ dataDay.getFullTimeNormOne());
        System.out.println("Time Norm 1 = "+ dataDay.getFullTimeNormTwo()+"\n");

        System.out.println("Error full   = "+ dataDay.getErrorFull());
        System.out.println("Error Float  = "+ dataDay.getErrorFlow());
        System.out.println("Error Temper = "+ dataDay.getErrorTemper()+"\n");
    }
}
//        list.add(104);
//        list.add(78);
//        list.add(78);
//        list.add(104);
//        list.add(8);
//        list.add(1);
//        list.add(114);
//        list.add(48);
//        list.add(21);
//        list.add(16);
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(4);
//        list.add(4);
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(0);
//        list.add(4);
//        list.add(109);
//        list.add(13);
//        list.add(22);
//        list.add(47);
//        list.add(34);
//        list.add(4);
//        list.add(19);
//        list.add(15);
//        list.add(174);
//        list.add(171);
//        list.add(0);
//        list.add(5);
//        list.add(62);
//        list.add(250);
//        list.add(237);
//        list.add(235);
//        list.add(59);
//        list.add(2);
//        list.add(253);
//        list.add(23);
//        list.add(0);
//        list.add(0);
//        list.add(130);
//        list.add(64);
//        list.add(253);
//        list.add(23);
//        list.add(0);
//        list.add(0);
//        list.add(130);
//        list.add(128);
//        list.add(64);
//        list.add(253);
//        list.add(23);
//        list.add(0);
//        list.add(0);
//        list.add(4);
//        list.add(32);
//        list.add(0);
//        list.add(98);
//        list.add(29);
//        list.add(1);
//        list.add(4);
//        list.add(36);
//        list.add(112);
//        list.add(92);
//        list.add(29);
//        list.add(1);
//        list.add(132);
//        list.add(64);
//        list.add(36);
//        list.add(112);
//        list.add(92);
//        list.add(29);
//        list.add(1);
//        list.add(132);
//        list.add(128);
//        list.add(64);
//        list.add(36);
//        list.add(0);
//        list.add(114);
//        list.add(29);
//        list.add(1);
//        list.add(94);
//        list.add(22);