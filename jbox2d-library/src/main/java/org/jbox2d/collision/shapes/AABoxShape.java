/*******************************************************************************
 * Copyright (c) 2014, Michael Boccara
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 	* Redistributions of source code must retain the above copyright notice,
 * 	  this list of conditions and the following disclaimer.
 * 	* Redistributions in binary form must reproduce the above copyright notice,
 * 	  this list of conditions and the following disclaimer in the documentation
 * 	  and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package org.jbox2d.collision.shapes;

import org.jbox2d.collision.AABB;
import org.jbox2d.collision.RayCastInput;
import org.jbox2d.collision.RayCastOutput;

import org.jbox2d.common.Rot;
import org.jbox2d.common.Settings;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

/**
 * A circle shape.
 */
public class AABoxShape extends Shape {

  public float m_w2;
  public float m_h2;

  public AABoxShape() {
    super(ShapeType.AABOX);
    m_w2 = m_h2 = 0;
    setRadius(Settings.polygonRadius);
  }

  public final Shape clone() {
    AABoxShape shape = new AABoxShape();
    shape.m_w2 = m_w2;
    shape.m_h2 = m_h2;
    shape.m_radius = m_radius;
    return shape;
  }

  /**
   * Build vertices to represent an axis-aligned box.
   * 
   * @param hx the half-width.
   * @param hy the half-height.
   */
  public final void set(final float halfWidth, final float halfHeight) {
	  m_w2 = halfWidth;
	  m_h2 = halfHeight;
  }

  public final int getChildCount() {
    return 1;
  }

  @Override
  public final boolean testPoint(final Transform transform, final Vec2 p) {
    final Rot q = transform.q;
    // this shape always has fixed rotation
    assert((q.c == 1.0f) && (q.s == 0.0f));
    final Vec2 lp = new Vec2(p.x - transform.p.x, p.y - transform.p.y);
    return (Math.abs(lp.x) <= (m_w2 + m_radius) && Math.abs(lp.y) <= (m_h2 + m_radius));
  }

  // Collision Detection in Interactive 3D Environments by Gino van den Bergen
  // From Section 3.1.2
  // x = s + a * r
  // norm(x) = radius

  @Override
  public final boolean raycast(RayCastOutput output, RayCastInput input, Transform transform,
      int childIndex) {
    //TODO
    
    return false;
  }

  @Override
  public final void computeAABB(final AABB aabb, final Transform transform, int childIndex) {
    //TODO
  }

  @Override
  public final void computeMass(final MassData massData, final float density) {
	    //TODO
  }
}
