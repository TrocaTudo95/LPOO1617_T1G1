package View.Entity;


import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Controller.Entity;

public class MarioView extends EntityView {
    private static final float DEFAULT_SCALE = 3;


    public MarioView(AssetManager assets, float screen_scale){
        super(DEFAULT_SCALE,screen_scale);
        this.loadImageNames();
        this.last_type = Entity.type.MARIO_RIGHT;
        this.assets=assets;
        Texture texture = assets.get(image_names.get(this.last_type));
        this.representation = new Sprite(texture,texture.getWidth(),texture.getHeight());
        this.representation.scale(this.img_scale);
    }

    @Override
    protected void loadImageNames(){
        this.image_names.put(Entity.type.MARIO_LEFT,        "mario/left.png");
        this.image_names.put(Entity.type.MARIO_RIGHT,       "mario/right.png");
        this.image_names.put(Entity.type.MARIO_CLIMB_LEFT,  "mario/climb_left.png");
        this.image_names.put(Entity.type.MARIO_CLIMB_RIGHT, "mario/climb_right.png");
        this.image_names.put(Entity.type.MARIO_RUN_LEFT,    "mario/run_left.png");
        this.image_names.put(Entity.type.MARIO_RUN_RIGHT,   "mario/run_right.png");
        this.image_names.put(Entity.type.MARIO_DYING_UP,    "mario/dying_up.png");
        this.image_names.put(Entity.type.MARIO_CLIMB_OVER,  "mario/climb_over.png");
    }

}




