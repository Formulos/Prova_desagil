package br.pro.hashi.ensino.desagil.lucianogic.model;

public class HalfGate extends Gate {
	private XorGate xorTop;
	private AndGate andBottom;

	public HalfGate() {
		super(2, 2);

		name = "Half";

		xorTop = new XorGate();

		andBottom = new AndGate();

	}

	@Override
	public boolean doRead(int index) {
		switch(index) {
		case 0:
			return xorTop.read();
			
		case 1:
			return andBottom.read();
		}
		return false;
	}

	@Override
	protected void doConnect(Emitter emitter, int index) {
		switch(index) {
		case 0:
			xorTop.connect(emitter, 0);
			andBottom.connect(emitter, 0);
			break;
		case 1:
			xorTop.connect(emitter, 1);
			andBottom.connect(emitter, 1);
			break;
		}
	}
}
