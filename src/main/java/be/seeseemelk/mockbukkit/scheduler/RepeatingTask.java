package be.seeseemelk.mockbukkit.scheduler;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class RepeatingTask extends ScheduledTask
{

	private final long period;

	public RepeatingTask(int id, Plugin plugin, boolean isSync, long scheduledTick, long period, @NotNull Runnable runnable)
	{
		super(id, plugin, isSync, scheduledTick, runnable);
		this.period = period;
	}

	public RepeatingTask(int id, Plugin plugin, boolean isSync, long scheduledTick, long period, @NotNull Consumer<BukkitTask> consumer)
	{
		super(id, plugin, isSync, scheduledTick, consumer);
		this.period = period;
	}

	/**
	 * Gets the period of the timer.
	 *
	 * @return The period of the timer.
	 */
	public long getPeriod()
	{
		return period;
	}

	/**
	 * Updates the scheduled tick for the next run.
	 */
	public void updateScheduledTick()
	{
		setScheduledTick(getScheduledTick() + period);
	}

}
