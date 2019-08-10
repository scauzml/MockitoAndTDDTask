package sales;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SalesApp {

	SalesDao salesDao;
	SalesReportDao salesReportDao;
	EcmService ecmService;

	public EcmService getEcmService() {
		return ecmService;
	}

	public void setEcmService(EcmService ecmService) {
		this.ecmService = ecmService;
	}

	public void setSalesDao(SalesDao salesDao) {
		this.salesDao = salesDao;
	}

	public void setSalesReportDao(SalesReportDao salesReportDao) {
		this.salesReportDao = salesReportDao;
	}

	public SalesDao getSalesDao() {
		return salesDao;
	}

	public SalesReportDao getSalesReportDao() {
		return salesReportDao;
	}

	public void generateSalesActivityReport(String salesId, int maxRow, boolean isNatTrade, boolean isSupervisor) {
		
		//SalesDao salesDao = new SalesDao();
		SalesDao salesDao = getSalesDao();
		//SalesReportDao salesReportDao = new SalesReportDao();
		SalesReportDao salesReportDao = getSalesReportDao();
		List<String> headers = null;
		
		List<SalesReportData> filteredReportDataList = new ArrayList<SalesReportData>();
		
		if (salesId == null) {
			return;
		}
		
		Sales sales = salesDao.getSalesBySalesId(salesId);
		
		Date today = new Date();
		Date date=sales.getEffectiveTo();
		if (today.after(sales.getEffectiveTo())
				|| today.before(sales.getEffectiveFrom())){
			return;
		}
		
		List<SalesReportData> reportDataList = salesReportDao.getReportData(sales);
		
		for (SalesReportData data : reportDataList) {
			if ("SalesActivity".equalsIgnoreCase(data.getType())) {
				if (data.isConfidential()) {
					if (isSupervisor) {
						filteredReportDataList.add(data);
					}
				}else {
					filteredReportDataList.add(data);
				}
			}
		}
		
		List<SalesReportData> tempList = new ArrayList<SalesReportData>();
		for (int i=0; i < reportDataList.size() || i < maxRow; i++) {
			tempList.add(reportDataList.get(i));
		}
		filteredReportDataList = tempList;
		
		if (isNatTrade) {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Time");
		} else {
			headers = Arrays.asList("Sales ID", "Sales Name", "Activity", "Local Time");
		}
		
		SalesActivityReport report = this.generateReport(headers, reportDataList);
		
		EcmService ecmService =getEcmService();

		ecmService.uploadDocument(report.toXml());
		
	}

	protected SalesActivityReport generateReport(List<String> headers, List<SalesReportData> reportDataList) {
		// TODO Auto-generated method stub
		return null;
	}

}
