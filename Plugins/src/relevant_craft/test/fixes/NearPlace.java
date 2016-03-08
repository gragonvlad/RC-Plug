package relevant_craft.test.fixes;
 
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
 
@SuppressWarnings("deprecation")
public class NearPlace implements Listener {
 
    // Установка труб
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlacePipes(BlockPlaceEvent e) {

		Block b = e.getBlock();
		BlockFace[] faces = { BlockFace.DOWN, BlockFace.UP, BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };

	for (BlockFace bf : faces)	// 1405:2
		if ((isPipe(b) && b.getRelative(bf).getTypeId() == 1405 && b.getRelative(bf).getData() == 2) || (isPipe(b.getRelative(bf)) && b.getTypeId() == 1405 && b.getData() == 2))
				{
				e.getPlayer().sendMessage("§a[§6RC-Fix§a]§c Эти блоки нельзя ставить рядом!");
				e.setCancelled(true);
				}
	}
 
    private boolean isPipe(Block b) {
        if (b == null)
            return true;
 
        int[] pipes = { 154, 1519, 1513, 903, 901 };
        for (int pipe : pipes)
            if (b.getTypeId() == pipe)
                return true;
        return false;
    }
 
    // Code by BydloCoder :D
    /*
     * @EventHandler (priority = EventPriority.HIGHEST) public void
     * onPlacePipes(BlockPlaceEvent e) { if ((e.getBlock() != null) &&
     * (e.getPlayer() != null)) { Block b = e.getBlock(); int id =
     * b.getTypeId(); if ((id == 1513) || (id == 154)) { World w =
     * e.getBlock().getWorld();
     * 
     * Block bx = w.getBlockAt(b.getLocation().getBlockX() + 1,
     * b.getLocation().getBlockY(), b.getLocation().getBlockZ()); Block bxx =
     * w.getBlockAt(b.getLocation().getBlockX() - 1,
     * b.getLocation().getBlockY(), b.getLocation().getBlockZ());
     * 
     * 
     * Block by = w.getBlockAt(b.getLocation().getBlockX(),
     * b.getLocation().getBlockY() + 1, b.getLocation().getBlockZ()); Block byy
     * = w.getBlockAt(b.getLocation().getBlockX(), b.getLocation().getBlockY() -
     * 1, b.getLocation().getBlockZ());
     * 
     * Block bz = w.getBlockAt(b.getLocation().getBlockX(),
     * b.getLocation().getBlockY(), b.getLocation().getBlockZ() + 1); Block bzz
     * = w.getBlockAt(b.getLocation().getBlockX(), b.getLocation().getBlockY(),
     * b.getLocation().getBlockZ() - 1); if (((bx.getTypeId() == 1405) &&
     * (bx.getData() == 5)) || ((bxx.getTypeId() == 1405) && (bxx.getData() ==
     * 5)) || ((by.getTypeId() == 1405) && (by.getData() == 5)) ||
     * ((byy.getTypeId() == 1405) && (byy.getData() == 5)) || ((bz.getTypeId()
     * == 1405) && (bz.getData() == 5)) || ((bzz.getTypeId() == 1405) &&
     * (bzz.getData() == 5)) || ((bx.getTypeId() == 4031) && (bx.getData() ==
     * 2)) || ((bxx.getTypeId() == 4031) && (bxx.getData() == 2)) ||
     * ((by.getTypeId() == 4031) && (by.getData() == 2)) || ((byy.getTypeId() ==
     * 4031) && (byy.getData() == 2)) || ((bz.getTypeId() == 4031) &&
     * (bz.getData() == 2)) || ((bzz.getTypeId() == 4031) && (bzz.getData() ==
     * 2))) { e.setCancelled(true); e.getPlayer().sendMessage(
     * "§a[§6RC-Fix§a]§c Эти блоки нельзя ставить рядом!"); } else { return; } }
     * else { if ((id == 4031) || (b.getData() == 1)) { World w =
     * e.getBlock().getWorld();
     * 
     * Block bx = w.getBlockAt(b.getLocation().getBlockX() + 1,
     * b.getLocation().getBlockY(), b.getLocation().getBlockZ()); Block bxx =
     * w.getBlockAt(b.getLocation().getBlockX() - 1,
     * b.getLocation().getBlockY(), b.getLocation().getBlockZ());
     * 
     * 
     * Block by = w.getBlockAt(b.getLocation().getBlockX(),
     * b.getLocation().getBlockY() + 1, b.getLocation().getBlockZ()); Block byy
     * = w.getBlockAt(b.getLocation().getBlockX(), b.getLocation().getBlockY() -
     * 1, b.getLocation().getBlockZ());
     * 
     * Block bz = w.getBlockAt(b.getLocation().getBlockX(),
     * b.getLocation().getBlockY(), b.getLocation().getBlockZ() + 1); Block bzz
     * = w.getBlockAt(b.getLocation().getBlockX(), b.getLocation().getBlockY(),
     * b.getLocation().getBlockZ() - 1); if ((bx.getTypeId() == 1513) ||
     * (bxx.getTypeId() == 1513) || (by.getTypeId() == 1513) || (byy.getTypeId()
     * == 1513) || (bz.getTypeId() == 1513) || (bzz.getTypeId() == 1513)) {
     * e.setCancelled(true); e.getPlayer().sendMessage(
     * "§a[§6RC-Fix§a]§c Эти блоки нельзя ставить рядом!"); } else { return; } }
     * } } else {} }
     */
 
}