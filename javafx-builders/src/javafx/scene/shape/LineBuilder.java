/* 
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package javafx.scene.shape;

/**
Builder class for javafx.scene.shape.Line
@see javafx.scene.shape.Line
@deprecated This class is deprecated and will be removed in the next version
*/
@javax.annotation.Generated("Generated by javafx.builder.processor.BuilderProcessor")
@Deprecated
public class LineBuilder<B extends javafx.scene.shape.LineBuilder<B>> extends javafx.scene.shape.ShapeBuilder<B> implements javafx.util.Builder<javafx.scene.shape.Line> {
    protected LineBuilder() {
    }
    
    /** Creates a new instance of LineBuilder. */
    @SuppressWarnings({"deprecation", "rawtypes", "unchecked"})
    public static javafx.scene.shape.LineBuilder<?> create() {
        return new javafx.scene.shape.LineBuilder();
    }
    
    private int __set;
    public void applyTo(javafx.scene.shape.Line x) {
        super.applyTo(x);
        int set = __set;
        if ((set & (1 << 0)) != 0) x.setEndX(this.endX);
        if ((set & (1 << 1)) != 0) x.setEndY(this.endY);
        if ((set & (1 << 2)) != 0) x.setStartX(this.startX);
        if ((set & (1 << 3)) != 0) x.setStartY(this.startY);
    }
    
    private double endX;
    /**
    Set the value of the {@link javafx.scene.shape.Line#getEndX() endX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B endX(double x) {
        this.endX = x;
        __set |= 1 << 0;
        return (B) this;
    }
    
    private double endY;
    /**
    Set the value of the {@link javafx.scene.shape.Line#getEndY() endY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B endY(double x) {
        this.endY = x;
        __set |= 1 << 1;
        return (B) this;
    }
    
    private double startX;
    /**
    Set the value of the {@link javafx.scene.shape.Line#getStartX() startX} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B startX(double x) {
        this.startX = x;
        __set |= 1 << 2;
        return (B) this;
    }
    
    private double startY;
    /**
    Set the value of the {@link javafx.scene.shape.Line#getStartY() startY} property for the instance constructed by this builder.
    */
    @SuppressWarnings("unchecked")
    public B startY(double x) {
        this.startY = x;
        __set |= 1 << 3;
        return (B) this;
    }
    
    /**
    Make an instance of {@link javafx.scene.shape.Line} based on the properties set on this builder.
    */
    public javafx.scene.shape.Line build() {
        javafx.scene.shape.Line x = new javafx.scene.shape.Line();
        applyTo(x);
        return x;
    }
}
