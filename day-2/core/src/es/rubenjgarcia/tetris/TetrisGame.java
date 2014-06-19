package es.rubenjgarcia.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TetrisGame extends ApplicationAdapter {
	
	private Music music;
	private TextureAtlas blocks;
	private SpriteBatch batch;
	
	@Override
	public void create () {
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/tetris.mp3"));
		music.setLooping(true);
		music.play();
		
		blocks = new TextureAtlas(Gdx.files.internal("images/blocks.atlas"));
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		Sprite sSprite = new Sprite(blocks.findRegion("S"));
		sSprite.setRotation(90);
		sSprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		music.dispose();
		blocks.dispose();
	}
}
