package simulation;

import java.util.ArrayList;

import lab.LabFrame;
import lab.component.HorizontalGraduation;
import lab.component.VerticalGraduation;
import lab.component.data.DataTable;
import lab.component.data.Graph;
import lab.component.swing.input.Button;
import lab.component.swing.input.CheckBox;

//Vapor pressure simulation lab from Ms. Lund Easy Java

public class VaporPressure extends LabFrame {
	private static final long serialVersionUID = 1L;
	// initial values from simulation
	private int temperature = 0;
	private int dtemperature = 1;
	private double volume = 1;
	private double R = 8.314;
	private int time = 0;
	private int dtime = 1;
	private double[] vaporPressure = new double[4];
	private double[] molarity = new double[4];

	private Button play;
	private Button step;
	private Button reset;
	private Graph molarityGraph;
	private Graph vaporPressureGraph;
	private Graph pressureGraph;
	private CheckBox showTank;
	private CheckBox showEquipment;
	private CheckBox showPressureGraph;
	private DataTable<Double> vaporPressureMolarityTable;
	private DataTable<Double> vaporPressureTimeTable;

	public static void main(String args[]) {
		new VaporPressure("Vapor Pressure Lab", 930, 800);
	}

	public VaporPressure(String name, int width, int height) {
		super(name, width, height);
		getRoot().setLayout(0);
		play = new Button(100, 25, "Play") {
			@Override
			public void doSomething() {

			}
		};
		play.setOffset(60, 500);
		step = new Button(100, 25, "Step") {
			@Override
			public void doSomething() {

			}
		};
		step.setOffset(160, 500);
		reset = new Button(100, 25, "Reset") {
			@Override
			public void doSomething() {

			}
		};
		reset.setOffset(260, 500);
		HorizontalGraduation timeGraduation = new HorizontalGraduation(0, 100, 20, 10);
		VerticalGraduation molarityGraduation = new VerticalGraduation(54, 55.8, .2, .1);
		VerticalGraduation vaporPressureGraduation = new VerticalGraduation(0, 25, 5, 2.5);
		molarityGraph = new Graph(300, 400, "Molarity vs Time 20C, 30C, 40C, 60C", "Molarity H2O (mol/L)", "Time (s)",
				molarityGraduation, timeGraduation);
		molarityGraph.setOffset(60, 50);
		molarityGraduation.setTextOffset(-32);
		vaporPressureGraph = new Graph(300, 400, "Vapor Pressure vs Time 20C, 30C, 40C, 60C", "Vapor Pressure", "Time (s)",
				vaporPressureGraduation, timeGraduation);
		vaporPressureGraph.setOffset(500, 50);
		vaporPressureMolarityTable = new DataTable<Double>(600, 100, 2, 4, DataTable.ROW_TITLES_ONLY);
		vaporPressureMolarityTable.setOffset(60, 550);
		for(int i = 0; i < vaporPressure.length; i++){
			vaporPressure[i] = 0;
		}
		molarity[0] = 55.409;
		molarity[1] = 55.268;
		molarity[2] = 55.076;
		molarity[3] = 54.576;
		vaporPressureMolarityTable.setRowTitle(0, "Vapor Pressure");
		vaporPressureMolarityTable.setRowTitle(1, "Molarity H2O");
		vaporPressureMolarityTable.setRow(0, vaporPressure);
		vaporPressureMolarityTable.setRow(1, molarity);
		showTank = new CheckBox(210, 25, "Show Tank");
		showTank.setOffset(700, 550);
		showEquipment = new CheckBox(210, 25, "Show Equipment");
		showEquipment.setOffset(700, 575);
		showPressureGraph = new CheckBox(210, 25, "Show Pressure vs. Time Graph");
		showPressureGraph.setOffset(700, 600);
		addComponent(molarityGraph, vaporPressureGraph, play, step, reset, vaporPressureMolarityTable, showTank, showEquipment, showPressureGraph);
		start(30);
	}

	@Override
	public void update() {

	}

}