package CMPS280;

public interface IEmployeePerformance<T> {
	public final int totalDailySalesGoal = 1000;
	public final int empDailySalesGoal = 300;

	public abstract String isCostumerHappy();

	public abstract String dailySalesGoal();
}