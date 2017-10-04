package TestingJFreeChart;

public class GraphComparator implements Comparable{
	
	private String TeamNum = "";
	private double AverageVal = 0;
	
	public GraphComparator(){}
	
	public GraphComparator(String teamNum, double averageVal){
		TeamNum = teamNum;
		AverageVal = averageVal;
	}
	
	public String getTeamNum(){
		return TeamNum;
	}
	public void setTeamNum(String teamNum){
		TeamNum = teamNum;
	}
	
	public double getAverageVal(){
		return AverageVal;
	}
	public void setAverageVal(double averageVal){
		AverageVal = averageVal;
	}
	
	
	@Override
	public int compareTo(Object arg0) {
		if(arg0 instanceof GraphComparator){
			GraphComparator temp = (GraphComparator) arg0; 
			if(temp.getAverageVal() > this.getAverageVal()){
				return 1;
			}else if(temp.getAverageVal() == this.getAverageVal()){
				return 0;
			}else if(temp.getAverageVal() < this.getAverageVal()){
				return -1;
			}
		}
		return 0;
		
	}
	
}