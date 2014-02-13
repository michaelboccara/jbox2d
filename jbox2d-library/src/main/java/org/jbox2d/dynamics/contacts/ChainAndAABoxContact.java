package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

public class ChainAndAABoxContact extends Contact {

	public ChainAndAABoxContact(IWorldPool argPool) {
	    super(argPool);
	}

	  @Override
	  public void init(Fixture fA, int indexA, Fixture fB, int indexB) {
	    super.init(fA, indexA, fB, indexB);
	    assert (m_fixtureA.getType() == ShapeType.CHAIN);
	    assert (m_fixtureB.getType() == ShapeType.AABOX);
	  }

	@Override
	public void evaluate(Manifold manifold, Transform xfA, Transform xfB) {
		// TODO Auto-generated method stub

	}

}
