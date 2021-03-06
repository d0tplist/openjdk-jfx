/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package touchsuite;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.SwipeEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.input.TouchPoint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class DrawLine extends Application {

    long start = -1;
    long end = -1;
    Line line;
    long id1, id2;

    @Override public void start(Stage stage) {
        stage.setTitle("Draw Line");

        final Group root = new Group();
        final Scene scene = new Scene(root, 500, 500);

        final Rectangle bg = new Rectangle(500, 500, Color.WHITE);

        root.getChildren().add(bg);

        root.setOnSwipeLeft(new EventHandler<SwipeEvent>() {
            @Override public void handle(SwipeEvent event) {
                if (event.getTouchCount() == 1) {
                    root.getChildren().clear();
                    root.getChildren().add(bg);
                }
                event.consume();
            }
        });

        root.setOnTouchPressed(new EventHandler<TouchEvent>() {
            @Override public void handle(TouchEvent event) {
                if (event.getTouchCount() == 2 && id1 == id2) {
                    TouchPoint first = event.getTouchPoints().get(0);
                    TouchPoint second = event.getTouchPoints().get(1);

                    line = new Line(first.getX(), first.getY(),
                            second.getX(), second.getY());
                    id1 = first.getId();
                    id2 = second.getId();
                    root.getChildren().add(line);
                }
                event.consume();
            }
        });

        root.setOnTouchReleased(new EventHandler<TouchEvent>() {
            @Override public void handle(TouchEvent event) {
                if (line == null) {
                    return;
                }
                if (event.getTouchPoint().getId() == id1) {
                    id1 = -1;
                }
                if (event.getTouchPoint().getId() == id2) {
                    id2 = -1;
                }
                if (id1 == id2) { // both are -1
                    line.setStrokeWidth(3);
                    line = null;
                }
                event.consume();
            }
        });

        root.setOnTouchMoved(new EventHandler<TouchEvent>() {
            @Override public void handle(TouchEvent event) {
                if (line == null) {
                    return;
                }
                TouchPoint tp = event.getTouchPoint();
                if (tp.getId() == id1) {
                    line.setStartX(tp.getX());
                    line.setStartY(tp.getY());
                }
                if (tp.getId() == id2) {
                    line.setEndX(tp.getX());
                    line.setEndY(tp.getY());
                }
                event.consume();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public static String info() {
        return
                "This application demonstrates drawing a line using two fingers. "
                + "When you put two fingers on the screen, a line appears. Each "
                + "finger then drags its line end point around until it is "
                + "released. You can swipe left to clear the board.";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
