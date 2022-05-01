package com.nowcomputing.b.a.b;

import com.nowcomputing.f.h;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class f extends JToolBar implements ActionListener {
   private com.nowcomputing.b.a.a b;
   private ButtonGroup c = new ButtonGroup();
   HashMap a = new HashMap();

   public f(com.nowcomputing.b.a.a var1) {
      this.b = var1;
      this.setBorder(BorderFactory.createLineBorder(h.e, 1));
      this.setOrientation(1);
      this.setFloatable(false);
      this.setRollover(false);
      this.setOpaque(true);
      d var2 = new d(var1, true);
      this.a(new e(var1), "/resources/select.png", false, com.nowcomputing.f.a("SELECT_TOOL"));
      this.a(new b(var1), "/resources/move.png", false, com.nowcomputing.f.a("MOVE_TOOL"));
      this.a(var2, "/resources/pencil.png", true, com.nowcomputing.f.a("PENCIL_TOOL"));
      this.a(new d(var1, false), "/resources/eraser.png", false, com.nowcomputing.f.a("ERASER_TOOL"));
      var1.a((a)var2);
   }

   private void a(a var1, String var2, boolean var3, String var4) {
      g var5 = new g(var1, var2);
      var5.b.setIcon(new ImageIcon(this.getClass().getResource(var2)));
      var5.b.setToolTipText(var4);
      var5.b.setFocusable(false);
      var5.b.addActionListener(this);
      var5.b.setSelected(var3);
      this.add(var5.b);
      this.c.add(var5.b);
      this.a.put(var5.b, var5);
   }

   public void actionPerformed(ActionEvent var1) {
      this.b.z();
      JToggleButton var2 = (JToggleButton)var1.getSource();
      this.c.clearSelection();
      var2.setSelected(true);
      a var3 = this.b.l();
      var3.c();
      a var4 = ((g)this.a.get(var2)).a;
      this.b.a(var4);
      var4.a();
   }
}
