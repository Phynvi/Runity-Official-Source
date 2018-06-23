package io.battlerune.game.service;

import io.battlerune.BattleRune;
import io.battlerune.net.ServerPipelineInitializer;
import io.battlerune.util.Logger;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ResourceLeakDetector;

import java.util.concurrent.TimeUnit;

/**
 * The bootstrap that will prepare the game and net.
 * @author Seven
 */
public final class NetworkService {

	public void start(int port) throws Exception {
		Logger.log("Starting network service on port: " + port);

		ResourceLeakDetector.setLevel(ResourceLeakDetector.Level.PARANOID);
		final EventLoopGroup bossGroup = new NioEventLoopGroup();
		final EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
					.channel(NioServerSocketChannel.class)
					.childHandler(new ServerPipelineInitializer());

			ChannelFuture f = b.bind(port).syncUninterruptibly();

			BattleRune.serverStarted.set(true);

			Logger.log(String.format("Server built successfully (took %d seconds).", BattleRune.UPTIME.elapsedTime(TimeUnit.SECONDS)));
			BattleRune.UPTIME.reset();
			f.channel().closeFuture().sync();
		} catch (Exception ex) {
			Logger.error("Error starting network service.");
			Logger.parent(ex.getMessage());
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

}