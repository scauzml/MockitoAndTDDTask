package parking;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class VipParkingStrategyTest {

	@Test
    public void testPark_givenAVipCarAndAFullParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 4, Write a test case on VipParkingStrategy.park()
	    * With using Mockito spy, verify and doReturn */
        Car car = Mockito.mock(Car.class);
        Car car1 = Mockito.mock(Car.class);
        when(car1.getName()).thenReturn("A");
        ParkingLot fullParkingLot=new ParkingLot("ParkingLot1",1);
        fullParkingLot.getParkedCars().add(car);

        ParkingLot parkingLot1=new ParkingLot("parlot2",1);
        List<ParkingLot> lots = new ArrayList<>();
        lots.add(fullParkingLot);
        lots.add(parkingLot1);
        VipParkingStrategy spy = Mockito.spy(new VipParkingStrategy());
        Receipt receipt = spy.park(lots, car);
        Mockito.verify(spy, times(1)).createReceipt(fullParkingLot,car1);



    }

    @Test
    public void testPark_givenCarIsNotVipAndAFullParkingLog_thenGiveNoSpaceReceipt() {

        /* Exercise 4, Write a test case on VipParkingStrategy.park()
         * With using Mockito spy, verify and doReturn */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsVipCar_thenReturnTrue(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
//        Car car = Mockito.mock(Car.class);
//        Car car1 = Mockito.mock(Car.class);
//        when(car1.getName()).thenReturn("A");
//        ParkingLot fullParkingLot=new ParkingLot("ParkingLot1",1);
//        fullParkingLot.getParkedCars().add(car);
//
//        ParkingLot parkingLot1=new ParkingLot("parlot2",1);
//        List<ParkingLot> lots = new ArrayList<>();
//        lots.add(fullParkingLot);
//        lots.add(parkingLot1);
//        VipParkingStrategy spy = Mockito.spy(new VipParkingStrategy());
//        Receipt receipt = spy.park(lots, car);
//        Mockito.verify(spy, times(1)).createReceipt(fullParkingLot,car1);

        Car car = Mockito.mock(Car.class);
        CarDao carDao = Mockito.spy(CarDao.class);

    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsVipCar_thenReturnFalse(){

        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameContainsCharacterAAndIsNotVipCar_thenReturnFalse(){
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
    }

    @Test
    public void testIsAllowOverPark_givenCarNameDoesNotContainsCharacterAAndIsNotVipCar_thenReturnFalse() {
        /* Exercise 5, Write a test case on VipParkingStrategy.isAllowOverPark()
         * You may refactor the code, or try to use
         * use @RunWith(MockitoJUnitRunner.class), @Mock (use Mockito, not JMockit) and @InjectMocks
         */
    }

    private Car createMockCar(String carName) {
        Car car = mock(Car.class);
        when(car.getName()).thenReturn(carName);
        return car;
    }
}
