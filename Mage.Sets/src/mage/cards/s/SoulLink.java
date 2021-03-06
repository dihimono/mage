
package mage.cards.s;

import java.util.UUID;
import mage.abilities.Ability;
import mage.abilities.common.DealsDamageAttachedTriggeredAbility;
import mage.abilities.common.DealtDamageAttachedTriggeredAbility;
import mage.abilities.dynamicvalue.common.NumericSetToEffectValues;
import mage.abilities.effects.common.AttachEffect;
import mage.abilities.effects.common.GainLifeEffect;
import mage.abilities.keyword.EnchantAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.SubType;
import mage.constants.Outcome;
import mage.constants.Zone;
import mage.target.TargetPermanent;
import mage.target.common.TargetCreaturePermanent;

/**
 *
 * @author LoneFox
 */
public final class SoulLink extends CardImpl {

    public SoulLink(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{1}{W}{B}");
        this.subtype.add(SubType.AURA);

        // Enchant creature
        TargetPermanent auraTarget = new TargetCreaturePermanent();
        this.getSpellAbility().addTarget(auraTarget);
        this.getSpellAbility().addEffect(new AttachEffect(Outcome.BoostCreature));
        Ability ability = new EnchantAbility(auraTarget.getTargetName());
        this.addAbility(ability);
        // Whenever enchanted creature deals damage, you gain that much life.
        this.addAbility(new DealsDamageAttachedTriggeredAbility(Zone.BATTLEFIELD,
            new GainLifeEffect(new NumericSetToEffectValues("that much", "damage")), false));
        // Whenever enchanted creature is dealt damage, you gain that much life.
        this.addAbility(new DealtDamageAttachedTriggeredAbility(new GainLifeEffect(new NumericSetToEffectValues("that much", "damage")), false));
    }

    public SoulLink(final SoulLink card) {
        super(card);
    }

    @Override
    public SoulLink copy() {
        return new SoulLink(this);
    }
}
