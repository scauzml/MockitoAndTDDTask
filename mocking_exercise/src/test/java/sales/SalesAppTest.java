package sales;

import org.junit.Test;
import org.mockito.Mockito;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


public class SalesAppTest {

	@Test
	public void testGenerateReport() throws ParseException {

		SalesDao salesDao = Mockito.mock(SalesDao.class);
		SalesReportDao salesReportDao = Mockito.mock(SalesReportDao.class);
		Sales sales = Mockito.mock(Sales.class);
		EcmService ecmService = Mockito.mock(EcmService.class);
		SalesActivityReport report = Mockito.mock(SalesActivityReport.class);

		int maxRow=1000;
		List<SalesReportData> reportDataList = new ArrayList<>();

		for (int i=0;i<maxRow;i++){
			SalesReportData salesReportData = Mockito.mock(SalesReportData.class);
			reportDataList.add(salesReportData);
			when(salesReportData.getType()).thenReturn("");
		}

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date1 = dateFormat.parse("2019-08-09 00:00:00");
		Date date2 = dateFormat.parse("2020-08-09 00:00:00");


		when(salesDao.getSalesBySalesId(Mockito.any())).thenReturn(sales);
        when(sales.getEffectiveFrom()).thenReturn(date1);
		when(sales.getEffectiveTo()).thenReturn(date2);
		when(salesReportDao.getReportData(Mockito.any())).thenReturn(reportDataList);
		when(report.toXml()).thenReturn("");
		SalesApp salesApp = Mockito.spy(new SalesApp());

		doReturn(salesDao).when(salesApp).getSalesDao();
		doReturn(salesReportDao).when(salesApp).getSalesReportDao();
		doReturn(ecmService).when(salesApp).getEcmService();
		doReturn(report).when(salesApp).generateReport(Mockito.any(),Mockito.any());


		salesApp.generateSalesActivityReport("DUMMY", maxRow, false, false);

		Mockito.verify(ecmService, times(1)).uploadDocument(Mockito.any());

	}
}
