package LeChatelierConcentration;

import lab.LabFrame;
import lab.component.EmptyComponent;
import lab.component.container.Bulb;
import lab.component.data.Graph;
import lab.component.swing.Label;
import lab.component.swing.input.Button;
import lab.component.swing.input.LabeledDoubleSlider;
import lab.util.HorizontalGraduation;
import lab.util.SigFig;
import lab.util.VerticalGraduation;

public class LeChatelierConcentration extends LabFrame{

	private static final long serialVersionUID = 2402023506629915960L;

	private Bulb bulb;
	private LabeledDoubleSlider cSlider;
	private LabeledDoubleSlider h2oSlider;
	private LabeledDoubleSlider coSlider;
	private LabeledDoubleSlider h2Slider;
	
	private Label cLabel;
	private Label h2oLabel;
	private Label coLabel;
	private Label h2Label;
	
	private Button resetButton;
	
	private Graph graph;
	
	public static void main(String[] args) {
		new LeChatelierConcentration("LeChatelier",1000,800);
	}
	
	public LeChatelierConcentration(String name,int width, int height) {
		super(name,width,height);
		
		bulb = new Bulb(250,250);
		addComponent(bulb);
		
		EmptyComponent sliderHolder = new EmptyComponent(350,400);
		
		cSlider = new LabeledDoubleSlider(250,0.01,1,.00009,5, 0) {
			@Override
			public void update() {
				cSlider.getLabel().setText(SigFig.sigfigalize(getValue(), cSlider.getSigFigs()) + " Moles C");
			}
		};
		cSlider.getLabel().setWidth(cSlider.getLabel().getWidth()+100);
		sliderHolder.addChild(cSlider);
		
		h2oSlider = new LabeledDoubleSlider(250,0.01,1,.00009,5, 0) {
			@Override
			public void update() {
				h2oSlider.getLabel().setText(SigFig.sigfigalize(getValue(), h2oSlider.getSigFigs()) + " Moles H2O");
			}
		};
		h2oSlider.getLabel().setWidth(h2oSlider.getLabel().getWidth()+100);
		h2oSlider.setOffsetY(10);
		sliderHolder.addChild(h2oSlider);
		
		coSlider = new LabeledDoubleSlider(250,0.01,1,.00009,5, 0) {
			@Override
			public void update() {
				coSlider.getLabel().setText(SigFig.sigfigalize(getValue(), coSlider.getSigFigs()) + " Moles CO");
			}
		};
		coSlider.getLabel().setWidth(coSlider.getLabel().getWidth()+100);
		coSlider.setOffsetY(10);
		sliderHolder.addChild(coSlider);
		
		h2Slider = new LabeledDoubleSlider(250,0.01,1,.00009,5, 0) {
			@Override
			public void update() {
				h2Slider.getLabel().setText(SigFig.sigfigalize(getValue(), h2Slider.getSigFigs()) + " Moles H2");
			}
		};
		h2Slider.getLabel().setWidth(h2Slider.getLabel().getWidth()+100);
		h2Slider.setOffsetY(10);
		sliderHolder.addChild(h2Slider);
		
		sliderHolder.setOffsetY(300);
		sliderHolder.setOffsetX(-250);
		
		addComponent(sliderHolder);
		
		graph = new Graph(250,250,"Moles of Substances","time (s)","moles",new HorizontalGraduation(0,100,10,5),new VerticalGraduation(0,.00250,.0005,.00025));
		graph.setOffsetX(100);
		addComponent(graph);
		
		EmptyComponent labelHolder = new EmptyComponent(800,200);
		labelHolder.addChild(new Label(800,100,"Measured Amounts of Material in the Glass Bulb"));
		cLabel = new Label(200,100,"C - " + cSlider.getValue() + " moles");
		labelHolder.addChild(cLabel);
		
		labelHolder.setOffsetX(-500);
		labelHolder.setOffsetY(600);
		addComponent(labelHolder);
		
		
		start(60);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
