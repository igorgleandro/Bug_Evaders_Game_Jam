package io.codeforall.bootcamp.filhosdamain.gameObject;

import io.codeforall.bootcamp.filhosdamain.positions.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class BugProjectile {
    private static final int PROJECTILE_SPEED = 10;
    private Position position;
    private Picture projectileImage;

    public BugProjectile(Position position) {
        this.position = position;
        this.projectileImage = new Picture(position.getX(), position.getY(), "bug.png");
        this.projectileImage.draw();
    }

    public void moveUp() {
        position.setY(position.getY() - PROJECTILE_SPEED);
        projectileImage.translate(0, -PROJECTILE_SPEED);
    }

    public boolean checkCollision(Enemy enemy) {

        return enemy.getPosition().getX() <= (this.getPosition().getX()) && (enemy.getPosition().getX() + enemy.getPicture().getWidth()) >= this.getPosition().getX() && enemy.getPosition().getY() == this.getPosition().getY();

    }

    public void delete() {
        projectileImage.delete();
    }

    public Position getPosition() {
        return position;
    }


    @Override
    public String toString() {
        return "BugProjectile{" +
                "position=" + position +
                ", projectileImage=" + projectileImage +
                '}';
    }
}