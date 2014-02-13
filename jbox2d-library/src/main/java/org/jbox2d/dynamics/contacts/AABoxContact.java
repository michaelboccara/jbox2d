package org.jbox2d.dynamics.contacts;

import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Transform;
import org.jbox2d.dynamics.Fixture;
import org.jbox2d.pooling.IWorldPool;

public class AABoxContact extends Contact {

	public AABoxContact(IWorldPool argPool) {
		super(argPool);
	}

	  public void init(Fixture fixtureA, Fixture fixtureB) {
		    super.init(fixtureA, 0, fixtureB, 0);
		    assert (m_fixtureA.getType() == ShapeType.AABOX);
		    assert (m_fixtureB.getType() == ShapeType.AABOX);
		  }

	@Override
	public void evaluate(Manifold manifold, Transform xfA, Transform xfB) {
		// TODO Auto-generated method stub

	}

}
