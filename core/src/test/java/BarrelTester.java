package test.java;


import com.mygdx.game.MyGdxGame;

import org.junit.Test;

import Model.Barrel;
import Model.Entity;
import Model.Pair;

import static org.junit.Assert.assertEquals;

public class BarrelTester extends GameTest {
    private Entity barrel;


    @Test
   public void testCreateBarrel(){
        this.barrel= Barrel.createBarrel(this.map, new Pair<Boolean, Boolean>(false,false));
        Pair<Integer,Integer> map_pos = new Pair<Integer,Integer>(0,6),
                pixel_pos = this.map.mapPosToPixels(map_pos);
        barrel.setPos(pixel_pos);
        assertEquals(Entity.type.BARREL_ROLLING1,barrel.getType());
        barrel.setRepSize(4, 4, MyGdxGame.DEFAULT_SCALE);
        assertEquals( new Pair<Integer,Integer>(4,4), barrel.getRepSize() );
        pixel_pos=new Pair<Integer, Integer>(10,10);
        barrel.setPos(pixel_pos);
        assertEquals(pixel_pos,barrel.getPos());
        barrel.setType(Entity.type.BARREL_ROLLING2);
        assertEquals(Entity.type.BARREL_ROLLING2,barrel.getType());

    }


    @Test
    public void moveRollingBarrel(){
        barrel= Barrel.createBarrel(this.map, new Pair<Boolean, Boolean>(false,false));
        Pair<Integer,Integer> map_pos = new Pair<Integer,Integer>(1,15),
                pixel_pos = this.map.mapPosToPixels(map_pos);
        barrel.setPos(pixel_pos);
        barrel.setRepSize(4, 4, MyGdxGame.DEFAULT_SCALE);
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos.setFirst(pixel_pos.getFirst() +3);
        assertEquals(pixel_pos,barrel.getPos());
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos.setFirst(pixel_pos.getFirst() +3);
        assertEquals(pixel_pos,barrel.getPos());
        ((Barrel)barrel).invertDirection();
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos.setFirst(pixel_pos.getFirst() -3);
        assertEquals(pixel_pos,barrel.getPos());

    }


    @Test
    public void moveFallingBarrel(){
        barrel= Barrel.createBarrel(this.map, new Pair<Boolean, Boolean>(false,true));
        Pair<Integer,Integer> map_pos = new Pair<Integer,Integer>(1,15),
                pixel_pos = this.map.mapPosToPixels(map_pos);
        barrel.setPos(pixel_pos);
        barrel.setRepSize(4, 4, MyGdxGame.DEFAULT_SCALE);


        assertEquals(Entity.type.BARREL_FALL_FRONT,barrel.getType());
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos.setSecond(pixel_pos.getSecond() -2);
        assertEquals(pixel_pos,barrel.getPos());
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos.setSecond(pixel_pos.getSecond() -2);
        assertEquals(pixel_pos,barrel.getPos());

    }

    @Test
    public void startFalling(){
        barrel= Barrel.createBarrel(this.map, new Pair<Boolean, Boolean>(false,false));
        Pair<Integer,Integer> map_pos = new Pair<Integer,Integer>(6,15),
                pixel_pos = this.map.mapPosToPixels(map_pos);
        barrel.setPos(pixel_pos);
        barrel.setRepSize(4, 4, MyGdxGame.DEFAULT_SCALE);

        assertEquals(Entity.type.BARREL_ROLLING1,barrel.getType());
        assertEquals(pixel_pos,barrel.getPos());
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos.setFirst(pixel_pos.getFirst()+15);
        assertEquals(Entity.type.BARREL_FALL_FRONT,barrel.getType());

        assertEquals(pixel_pos,barrel.getPos());
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        pixel_pos=barrel.getPos();
        assertEquals(Entity.type.BARREL_FALL_FRONT,barrel.getType());
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));
        barrel= barrel.moveEntity(this.map,new Pair<Integer, Integer>(0,0));


    }
}
