package br.pro.hashi.ensino.desagil.lucianogic.model;

public class FullGate extends Gate {
	private XorGate xorTop;
	private XorGate xorBottom;
	private AndGate andBottom;
	private AndGate andTop;
	private OrGate or;

	public FullGate() {
		super(3, 2);

		name = "Full";

		xorTop = new XorGate();
		
		
		xorBottom = new XorGate();
		xorBottom.connect(xorTop, 0);
		
		andTop = new AndGate();
		andTop.connect(xorTop, 0);
		
		andBottom = new AndGate();
		
		or = new OrGate();
		or.connect(andTop, 0);
		or.connect(andBottom, 1);

	}

	@Override
	public boolean doRead(int index) {
		switch(index) {
		case 0:
			return xorBottom.read();
			
		case 1:
			return or.read();
			
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
		case 2:
			xorBottom.connect(emitter, 1);
			andTop.connect(emitter, 1);
			break;
			
		}
	}
}

