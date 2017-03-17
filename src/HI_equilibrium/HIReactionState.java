package HI_equilibrium;

public class HIReactionState {

	public final double volume;
	public final double temperature;
	public final double HIPressureInitial;
	public final double H2PressureInitial;
	public final double I2PressureInitial;
	public final double HIPressureFinal;
	public final double H2PressureFinal;
	public final double I2PressureFinal;
	public final boolean HITube;
	public final boolean H2Tube;
	public final boolean I2Tube;

	public HIReactionState(double volume, double temperature, double hIPressureInitial, double h2PressureInitial,
			double i2PressureInitial, double hIPressureFinal, double h2PressureFinal, double i2PressureFinal,
			boolean hITube, boolean h2Tube, boolean i2Tube) {
		this.volume = volume;
		this.temperature = temperature;
		HIPressureInitial = hIPressureInitial;
		H2PressureInitial = h2PressureInitial;
		I2PressureInitial = i2PressureInitial;
		HIPressureFinal = hIPressureFinal;
		H2PressureFinal = h2PressureFinal;
		I2PressureFinal = i2PressureFinal;
		HITube = hITube;
		H2Tube = h2Tube;
		I2Tube = i2Tube;
	}

}
