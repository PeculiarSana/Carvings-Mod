package com.sana.carvings.commands;

import com.sana.carvings.Carvings;
import com.sana.carvings.blocks.BlockCarving;
import com.sana.carvings.capabilities.DiscoveredSymbolsProvider;
import com.sana.carvings.capabilities.ModCapabilities;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class CommandAddSymbol implements ICommand
{
    private List<String> aliases = new ArrayList<>();

    public CommandAddSymbol()
    {
        aliases.add("symbol");
        aliases.add("sym");
    }

    @Override
    public String getName()
    {
        return "symbol";
    }

    @Override
    public List<String> getAliases()
    {
        return aliases;
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/symbol <add|remove|get> <player> [symbol]";
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, java.lang.String[] args, @Nullable BlockPos targetPos)
    {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        World world = sender.getEntityWorld();

        if (!world.isRemote)
        {
            // ADD symbol
            if (args[0].equals("add"))
            {
                EntityPlayerMP player = null;

                if (args[1].equals("@p"))
                {
                    player = (EntityPlayerMP) sender;

                    Carvings.LOGGER.info(sender.getName() + " attempting to add symbol " + args[2] + " to self");

                    ModCapabilities.IDiscoveredSymbols symbols =  player.getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);
                    if (BlockCarving.getBlockFromName(args[2]) != null)
                    {
                        Carvings.LOGGER.info(BlockCarving.getBlockFromName(args[2]));
                        symbols.add(new ResourceLocation(args[2]));
                    }
                    else
                    {
                        Carvings.LOGGER.warn(args[2] + " does not exist in the registry.");
                    }
                }
                else
                {
                    List<EntityPlayerMP> playerList = server.getPlayerList().getPlayers();
                    for (int i = 0; i < playerList.size(); i++)
                    {
                        if (args[1].equals(playerList.get(i).getName()))
                        {
                            Carvings.LOGGER.info(sender.getName() + " adding symbol " + args[2] + " to " + player.getName());

                            ModCapabilities.IDiscoveredSymbols symbols =  player.getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);
                            //ResourceLocation rl = new ResourceLocation(args[2]);
                            if (BlockCarving.getBlockFromName(args[2]) != null)
                            {
                                symbols.add(new ResourceLocation(args[2]));
                            }
                        }
                    }
                }

                if (args[1].equals(player.getName()))
                {

                }
            }

            // GET symbol list
            if (args[0].equals("get"))
            {
                EntityPlayerMP player = null;

                if (args[1].equals("@p"))
                {
                    player = (EntityPlayerMP) sender;

                    Carvings.LOGGER.info(sender.getName() + " attempting to get symbol list of self.");

                    ModCapabilities.IDiscoveredSymbols symbols =  player.getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);

                    for (ResourceLocation rl : symbols.getSymbols())
                    {
                        player.sendMessage(new TextComponentString(rl.toString()));
                    }
                }
                else
                {
                    List<EntityPlayerMP> playerList = server.getPlayerList().getPlayers();
                    for (int i = 0; i < playerList.size(); i++)
                    {
                        if (args[1].equals(playerList.get(i).getName()))
                        {
                            Carvings.LOGGER.info(sender.getName() + " adding symbol " + args[2] + " to " + player.getName());

                            ModCapabilities.IDiscoveredSymbols symbols =  player.getCapability(DiscoveredSymbolsProvider.DISCOVERED_SYMBOLS, null);
                            //ResourceLocation rl = new ResourceLocation(args[2]);
                            if (BlockCarving.getBlockFromName(args[2]) != null)
                            {
                                symbols.add(new ResourceLocation(args[2]));
                            }
                        }
                    }
                }
            }
        }
        else
        {

        }

    }

    @Override
    public boolean isUsernameIndex(String[] args, int index)
    {
        return false;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public int compareTo(ICommand arg0) {
        return 0;
    }
}
