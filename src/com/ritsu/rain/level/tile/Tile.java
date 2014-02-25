package com.ritsu.rain.level.tile;

import com.ritsu.rain.graphics.Screen;
import com.ritsu.rain.graphics.Sprite;
import com.ritsu.rain.level.tile.spawn_level.SpawnFloorTile;
import com.ritsu.rain.level.tile.spawn_level.SpawnGrassTile;
import com.ritsu.rain.level.tile.spawn_level.SpawnHedgeTile;
import com.ritsu.rain.level.tile.spawn_level.SpawnWallTile;
import com.ritsu.rain.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile spawn_grass_tile = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge_tile = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water_tile = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall1_tile = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawn_wall2_tile = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor_tile = new SpawnFloorTile(Sprite.spawn_floor);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {
	}

	public boolean solid() {
		return false;
	}

}
