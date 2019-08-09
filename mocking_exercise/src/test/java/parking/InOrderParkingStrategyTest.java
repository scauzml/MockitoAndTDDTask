package parking;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class InOrderParkingStrategyTest {


	@Test
    public void testCreateReceipt_givenACarAndAParkingLog_thenGiveAReceiptWithCarNameAndParkingLotName() {

	    /* Exercise 1, Write a test case on InOrderParkingStrategy.createReceipt()
	    * With using Mockito to mock the input parameter */
         //given
        Car car = Mockito.mock(Car.class);
        ParkingLot parkingLot1 = Mockito.mock(ParkingLot.class);
        when(car.getName()).thenReturn("car1");
        when(parkingLot1.getName()).thenReturn("parkingLot1");




        InOrderParkingStrategy inOrderParkingStrategy = new InOrderParkingStrategy();
        Receipt park = inOrderParkingStrategy.createReceipt(parkingLot1, car);
        Assert.assertEquals("car1", park.getCarName());
        Assert.assertEquals("parkingLot1", park.getParkingLotName());



    }

    @Test
    public void testCreateNoSpaceReceipt_givenACar_thenGiveANoSpaceReceipt() {

        /* Exercise 1, Write a test case on InOrderParkingStrategy.createNoSpaceReceipt()
         * With using Mockito to mock the input parameter */

    }

    @Test
    public void testPark_givenNoAvailableParkingLot_thenCreateNoSpaceReceipt(){

	    /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for no available parking lot */
        Car car = Mockito.mock(Car.class);
        ParkingLot parkingLot=new ParkingLot("parlot1",0);
        List<ParkingLot> lots = new ArrayList<>();
        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        Receipt receipt = inOrderParkingStrategy.park(lots, car);
        Mockito.verify(inOrderParkingStrategy, times(1)).createNoSpaceReceipt(car);

    }

    @Test
    public void testPark_givenThereIsOneParkingLotWithSpace_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot */

    }

    @Test
    public void testPark_givenThereIsOneFullParkingLot_thenCreateReceipt(){

        /* Exercise 2: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for one available parking lot but it is full */

    }

    @Test
    public void testPark_givenThereIsMultipleParkingLotAndFirstOneIsFull_thenCreateReceiptWithUnfullParkingLot(){

        /* Exercise 3: Test park() method. Use Mockito.spy and Mockito.verify to test the situation for multiple parking lot situation */
        Car car = Mockito.mock(Car.class);
        ParkingLot parkingLot=new ParkingLot("parlot1",0);
        ParkingLot parkingLot1=new ParkingLot("parlot2",1);
        List<ParkingLot> lots = new ArrayList<>();
        lots.add(parkingLot);
        lots.add(parkingLot1);
        InOrderParkingStrategy inOrderParkingStrategy = Mockito.spy(new InOrderParkingStrategy());
        Receipt receipt = inOrderParkingStrategy.park(lots, car);
        Mockito.verify(inOrderParkingStrategy, times(1)).createReceipt(parkingLot1,car);

    }


}
