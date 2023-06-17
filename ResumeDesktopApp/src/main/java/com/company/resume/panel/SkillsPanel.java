/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.company.resume.panel;

import com.company.dao.inter.SkillDaoInter;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.UserSkill;
import com.company.main.Context;
import com.company.resume.config.Config;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class SkillsPanel extends javax.swing.JPanel {

    private UserSkillDaoInter userskill = Context.instanceUserSkillDao();
    private SkillDaoInter skilldao = Context.instanceSkillDao();

    /**
     * Creates new form NewJPanel1
     */
    public SkillsPanel() {
        initComponents();

    }

    private void fillWindow() {

        List<Skill> skill = skilldao.getAllSkill();
        for (Skill s : skill) {
            cbSkill.addItem(s);
        }
        fillTable();

    }
    private List<UserSkill> list;

    private void fillTable() {
        list = userskill.getAllUserSkills(Config.loggedInUser.getId());
        Vector<Vector> rows = new Vector<>();
        for (UserSkill l : list) {
            Vector<Object> row = new Vector();
            row.add(l.getSkill());
            row.add(l.getPower());
            rows.add(row);

        }
        Vector<String> column = new Vector();
        column.add("Skill");
        column.add("Power");
        DefaultTableModel model = new DefaultTableModel(rows, column);
        tblSkill.setModel(model);
    }

    public void fillUserComponents() {
        fillWindow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblSkill = new javax.swing.JTable();
        lblSkil = new javax.swing.JLabel();
        lblpower = new javax.swing.JLabel();
        sliderPower = new javax.swing.JSlider();
        cbSkill = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtSkill = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(32500, 32500));

        tblSkill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSkill);

        lblSkil.setText(" skill");

        lblpower.setText("  power");

        sliderPower.setMaximum(10);
        sliderPower.setMinimum(1);

        btnDelete.setText("-");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtSkill.setText("jTextField1");
        txtSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSkillActionPerformed(evt);
            }
        });

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSkil, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsave))
                        .addGap(18, 18, 18)
                        .addComponent(lblpower, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 183, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSkil, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblpower)
                    .addComponent(sliderPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete)
                        .addComponent(btnsave)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int index = tblSkill.getSelectedRow();
        UserSkill skill = list.get(index);
        userskill.removeSkill(skill.getId());
        fillWindow();
// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String skillname = txtSkill.getText();
        Skill skill = null;
        if (skillname != null && !skillname.trim().isEmpty()) {
            skill = new Skill(0, skillname);
            skilldao.addSkills(skill);
        } else {
            skill = (Skill) cbSkill.getSelectedItem();
        }
        int power = sliderPower.getValue();
        UserSkill us = new UserSkill(null, Config.loggedInUser, skill, power);
        userskill.addUserSkill(us);
        // TODO add your handling code here:
        fillWindow();
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSkillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSkillActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        UserSkill selectedUserSkill = list.get(tblSkill.getSelectedRow());
        String skillname = txtSkill.getText();
        Skill skill = null;
        if (skillname != null && !skillname.trim().isEmpty()) {
            skill = new Skill(0, skillname);
            skilldao.addSkills(skill);
        } else {
            skill = (Skill) cbSkill.getSelectedItem();
        }
        int power = sliderPower.getValue();
        selectedUserSkill.setPower(power);
        selectedUserSkill.setSkill(skill);
        userskill.updateUserSkill(selectedUserSkill);
        fillTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnsaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<Skill> cbSkill;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSkil;
    private javax.swing.JLabel lblpower;
    private javax.swing.JSlider sliderPower;
    private javax.swing.JTable tblSkill;
    private javax.swing.JTextField txtSkill;
    // End of variables declaration//GEN-END:variables
}
