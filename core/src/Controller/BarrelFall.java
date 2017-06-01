package Controller;

/**
 * Created by asus on 31/05/2017.
 */

class BarrelFall extends Barrel {
    private final int ANIMATION_RATE = 5;

    public BarrelFall(int x, int y, int x_dir) {
        super(x,y,x_dir);
        this.current_type = type.BARREL_FALL_FRONT;
    }

    @Override
    public Barrel moveBarrel(Map map) {
        Barrel ret_val = updatePosition(map);
        this.tickTock();
        return ret_val;
    }

    private Barrel updatePosition(Map map) {
        Pair<Integer,Integer> new_pos = new Pair<Integer, Integer>(this.position.getFirst(), this.position.getSecond() + this.getYSpeed() );
        int new_y;
        Barrel ret_val = this;
        if ( (new_y = map.collidesBottom(new_pos,this.rep_size.getFirst())) == -1 ){
            this.setPos(new_pos);
            this.updateYVelocity();
        }
        else
            ret_val = new BarrelRolling( new_pos.getFirst() , new_y , -this.x_direction);

        return ret_val;
    }

    @Override
    protected void tickTock() {
        if (ANIMATION_RATE == this.tick){
            if (type.BARREL_FALL_FRONT == this.current_type)
                this.current_type = type.BARREL_FALL_BACK;
            else
                this.current_type = type.BARREL_FALL_FRONT;
            this.tick=0;
        }
        this.tick++;
    }
}