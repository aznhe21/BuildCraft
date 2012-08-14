/** 
 * Copyright (c) SpaceToad, 2011
 * http://www.mod-buildcraft.com
 * 
 * BuildCraft is distributed under the terms of the Minecraft Mod Public 
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */

package buildcraft.energy;

import buildcraft.BuildCraftEnergy;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MovingObjectPosition;
import net.minecraft.src.World;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class OilBucketHandler{
	
    @ForgeSubscribe
    public void onBucketFill(FillBucketEvent event){
    	ItemStack result=fillCustomBucket(event.world,event.target);
    	if(result==null)
    	{
    		return;
    	}
    	event.result=result;
    	event.setHandeled();
    	return;
    	
    }
	public ItemStack fillCustomBucket(World w,MovingObjectPosition pos) {
		int blockID=w.getBlockId(pos.blockX,pos.blockY,pos.blockZ);
		if (( blockID== BuildCraftEnergy.oilStill.blockID || blockID == BuildCraftEnergy.oilMoving.blockID)
				&& w.getBlockMetadata(pos.blockX,pos.blockY,pos.blockZ) == 0) {

			w.setBlockWithNotify(pos.blockX,pos.blockY,pos.blockZ, 0);

			return new ItemStack(BuildCraftEnergy.bucketOil);
		} else {
			return null;
		}
	}

}