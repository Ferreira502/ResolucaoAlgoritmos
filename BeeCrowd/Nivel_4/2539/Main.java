<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agenda — Sistema de Produtividade</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,300;0,9..40,400;0,9..40,500;0,9..40,600;1,9..40,300&family=Instrument+Serif:ital@0;1&display=swap" rel="stylesheet">
<style>
/* ─── RESET & TOKENS ──────────────────────────────── */
*, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }
:root {
  --bg:       #f5f4f0;
  --surface:  #ffffff;
  --surface2: #f0efe9;
  --surface3: #e8e7e1;
  --border:   rgba(0,0,0,.08);
  --border2:  rgba(0,0,0,.14);
  --ink:      #1a1917;
  --ink2:     #5a5853;
  --ink3:     #9a9890;
  --accent:   #2563b8;
  --accent-l: #dce8f8;
  --accent-t: #1e4f96;
  --green:    #1a7f5a;
  --green-l:  #d4f0e5;
  --amber:    #b45309;
  --amber-l:  #fef3c7;
  --rose:     #be185d;
  --rose-l:   #fce7f3;
  --teal:     #0f766e;
  --teal-l:   #ccfbf1;
  --radius:   14px;
  --radius-sm:8px;
  --shadow:   0 1px 3px rgba(0,0,0,.06), 0 4px 16px rgba(0,0,0,.06);
  --shadow-l: 0 2px 8px rgba(0,0,0,.08), 0 12px 40px rgba(0,0,0,.1);
  --font:     'DM Sans', sans-serif;
  --serif:    'Instrument Serif', serif;
  --ease:     cubic-bezier(.4,0,.2,1);
}

html, body { height: 100%; }
body {
  font-family: var(--font);
  background: var(--bg);
  color: var(--ink);
  font-size: 14px;
  line-height: 1.5;
  -webkit-font-smoothing: antialiased;
  overflow: hidden;
}

button { font-family: var(--font); cursor: pointer; border: none; outline: none; }
input, select, textarea { font-family: var(--font); outline: none; }
input[type="date"]::-webkit-calendar-picker-indicator { opacity: .4; }

/* ─── SCROLLBAR ──────────────────────────────── */
::-webkit-scrollbar { width: 5px; height: 5px; }
::-webkit-scrollbar-track { background: transparent; }
::-webkit-scrollbar-thumb { background: var(--surface3); border-radius: 10px; }

/* ─── LAYOUT ──────────────────────────────── */
.app {
  display: grid;
  grid-template-rows: 56px 1fr;
  grid-template-columns: 240px 1fr;
  height: 100vh;
  max-width: 1440px;
  margin: 0 auto;
  position: relative;
}

/* ─── SIDEBAR ──────────────────────────────── */
.sidebar {
  grid-row: 1 / 3;
  background: var(--surface);
  border-right: 1px solid var(--border);
  display: flex;
  flex-direction: column;
  padding: 0;
  overflow: hidden;
}

.sidebar-brand {
  height: 56px;
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 0 20px;
  border-bottom: 1px solid var(--border);
}

.brand-icon {
  width: 30px; height: 30px;
  background: var(--ink);
  border-radius: 8px;
  display: flex; align-items: center; justify-content: center;
}
.brand-icon svg { width: 16px; height: 16px; fill: #fff; }
.brand-name {
  font-family: var(--serif);
  font-size: 18px;
  color: var(--ink);
  letter-spacing: -.01em;
}

.sidebar-nav { padding: 16px 12px; flex: 1; overflow-y: auto; }
.nav-label {
  font-size: 10px;
  font-weight: 600;
  letter-spacing: .1em;
  color: var(--ink3);
  text-transform: uppercase;
  padding: 0 8px;
  margin-bottom: 6px;
  margin-top: 16px;
}
.nav-label:first-child { margin-top: 0; }

.nav-btn {
  display: flex; align-items: center; gap: 10px;
  width: 100%;
  padding: 9px 10px;
  border-radius: var(--radius-sm);
  background: transparent;
  color: var(--ink2);
  font-size: 13.5px;
  font-weight: 400;
  transition: all .15s var(--ease);
  position: relative;
}
.nav-btn svg { width: 16px; height: 16px; flex-shrink: 0; opacity: .7; }
.nav-btn:hover { background: var(--surface2); color: var(--ink); }
.nav-btn.active {
  background: var(--ink);
  color: #fff;
  font-weight: 500;
}
.nav-btn.active svg { opacity: 1; }
.nav-badge {
  margin-left: auto;
  background: var(--rose);
  color: #fff;
  font-size: 10px;
  font-weight: 600;
  padding: 1px 6px;
  border-radius: 20px;
  min-width: 18px;
  text-align: center;
}
.nav-btn.active .nav-badge { background: rgba(255,255,255,.25); }

.sidebar-mini-cal { padding: 16px 14px 10px; border-top: 1px solid var(--border); }
.mini-cal-header {
  display: flex; align-items: center; justify-content: space-between;
  margin-bottom: 10px;
}
.mini-cal-title { font-size: 12px; font-weight: 500; color: var(--ink); }
.mini-nav { display: flex; gap: 2px; align-items: center; }
.mini-nav-btn {
  width: 24px; height: 24px;
  border-radius: 6px;
  border: none;
  background: transparent;
  color: var(--ink3);
  display: flex; align-items: center; justify-content: center;
  cursor: pointer;
  transition: background .12s, color .12s, transform .1s;
}
.mini-nav-btn svg { width: 14px; height: 14px; }
.mini-nav-btn:hover { background: var(--surface2); color: var(--ink); }
.mini-nav-btn:active { transform: scale(.88); background: var(--surface3); }
.mini-grid { display: grid; grid-template-columns: repeat(7,1fr); gap: 1px; }
.mini-dow {
  font-size: 9px; font-weight: 600;
  text-align: center; padding: 3px 0;
  color: var(--ink3);
  text-transform: uppercase;
}
.mini-day {
  aspect-ratio: 1;
  display: flex; align-items: center; justify-content: center;
  font-size: 11px;
  color: var(--ink2);
  border-radius: 50%;
  cursor: pointer;
  transition: all .12s;
}
.mini-day:hover { background: var(--surface2); color: var(--ink); }
.mini-day.other { color: var(--ink3); }
.mini-day.today { background: var(--ink); color: #fff; font-weight: 600; }
.mini-day.selected:not(.today) { background: var(--accent-l); color: var(--accent); font-weight: 500; }
.mini-day.has-event::after {
  content: '';
  position: absolute;
  bottom: 2px; left: 50%;
  transform: translateX(-50%);
  width: 3px; height: 3px;
  border-radius: 50%;
  background: var(--accent);
}
.mini-day { position: relative; }

/* ─── TOPBAR ──────────────────────────────── */
.topbar {
  background: var(--surface);
  border-bottom: 1px solid var(--border);
  display: flex;
  align-items: center;
  padding: 0 24px;
  gap: 12px;
}
.topbar-title {
  font-size: 20px;
  font-family: var(--serif);
  color: var(--ink);
  flex: 1;
}
.topbar-title span { color: var(--ink3); font-style: italic; }
.topbar-actions { display: flex; gap: 8px; align-items: center; }

.btn {
  display: inline-flex; align-items: center; gap: 6px;
  padding: 7px 14px;
  border-radius: var(--radius-sm);
  font-size: 13px;
  font-weight: 500;
  transition: all .15s var(--ease);
}
.btn-ghost {
  background: transparent;
  color: var(--ink2);
  border: 1px solid var(--border2);
}
.btn-ghost:hover { background: var(--surface2); color: var(--ink); }
.btn-primary {
  background: var(--ink);
  color: #fff;
  border: 1px solid transparent;
}
.btn-primary:hover { background: #2d2c2a; }
.btn-primary svg, .btn-ghost svg { width: 14px; height: 14px; }
.view-switcher {
  display: flex;
  background: var(--surface2);
  border-radius: var(--radius-sm);
  padding: 3px;
  gap: 2px;
}
.view-btn {
  padding: 4px 10px;
  border-radius: 6px;
  font-size: 12px;
  background: transparent;
  color: var(--ink3);
  font-weight: 500;
  transition: all .15s;
}
.view-btn.active { background: var(--surface); color: var(--ink); box-shadow: 0 1px 3px rgba(0,0,0,.08); }

/* ─── MAIN CONTENT ──────────────────────────────── */
.main { overflow: hidden; display: flex; flex-direction: column; }

/* ─── PANELS ──────────────────────────────── */
.panel { display: none; flex: 1; overflow: hidden; }
.panel.active { display: flex; }

/* ─── CALENDAR PANEL ──────────────────────────────── */
.cal-wrap { display: flex; flex: 1; overflow: hidden; }
.cal-body { flex: 1; display: flex; flex-direction: column; overflow: hidden; }
.cal-nav {
  display: flex; align-items: center;
  padding: 12px 20px;
  gap: 12px;
  background: var(--surface);
  border-bottom: 1px solid var(--border);
}
.cal-month-title {
  font-family: var(--serif);
  font-size: 22px;
  color: var(--ink);
  flex: 1;
}
.cal-month-title .year { color: var(--ink3); margin-left: 6px; font-style: italic; }
.cal-nav-group {
  display: flex;
  align-items: center;
  gap: 0;
  background: var(--surface);
  border: 1px solid var(--border2);
  border-radius: 10px;
  overflow: hidden;
}
.cal-nav-btn {
  width: 36px; height: 36px;
  background: transparent;
  color: var(--ink2);
  display: flex; align-items: center; justify-content: center;
  border: none;
  cursor: pointer;
  transition: background .14s, color .14s, transform .1s;
  position: relative;
}
.cal-nav-btn svg { width: 18px; height: 18px; transition: transform .15s var(--ease); }
.cal-nav-btn:hover { background: var(--surface2); color: var(--ink); }
.cal-nav-btn:hover.prev svg { transform: translateX(-2px); }
.cal-nav-btn:hover.next svg { transform: translateX(2px); }
.cal-nav-btn:active { background: var(--surface3); transform: scale(.93); }
.cal-nav-divider {
  width: 1px; height: 20px;
  background: var(--border2);
  flex-shrink: 0;
}
.today-pill {
  padding: 0 14px;
  height: 36px;
  border: none;
  border-left: 1px solid var(--border2);
  border-right: 1px solid var(--border2);
  background: transparent;
  font-size: 12.5px; font-weight: 500;
  color: var(--ink2);
  cursor: pointer;
  transition: background .14s, color .14s;
  white-space: nowrap;
  letter-spacing: .01em;
}
.today-pill:hover { background: var(--surface2); color: var(--ink); }
.today-pill:active { background: var(--surface3); }

.dow-row {
  display: grid; grid-template-columns: repeat(7,1fr);
  background: var(--surface);
  border-bottom: 1px solid var(--border);
}
.dow-cell {
  padding: 8px 0;
  text-align: center;
  font-size: 11px;
  font-weight: 600;
  letter-spacing: .06em;
  text-transform: uppercase;
  color: var(--ink3);
}

.cal-grid-scroll { flex: 1; overflow-y: auto; }
.cal-grid {
  display: grid;
  grid-template-columns: repeat(7,1fr);
  border-left: 1px solid var(--border);
  border-top: 1px solid var(--border);
}
.cal-cell {
  min-height: 110px;
  border-right: 1px solid var(--border);
  border-bottom: 1px solid var(--border);
  padding: 8px;
  background: var(--surface);
  cursor: pointer;
  transition: background .12s;
  position: relative;
  overflow: hidden;
}
.cal-cell:hover { background: #fafaf8; }
.cal-cell.other-month { background: var(--bg); }
.cal-cell.other-month .day-num { color: var(--ink3); }
.cal-cell.today { background: #fffef8; }
.cal-cell.selected { background: var(--accent-l); }

.day-num {
  font-size: 13px;
  font-weight: 500;
  color: var(--ink2);
  width: 26px; height: 26px;
  display: flex; align-items: center; justify-content: center;
  border-radius: 50%;
  margin-bottom: 4px;
  transition: all .12s;
}
.cal-cell.today .day-num {
  background: var(--ink);
  color: #fff;
  font-weight: 600;
}
.cal-cell.selected:not(.today) .day-num {
  background: var(--accent);
  color: #fff;
}

.event-pill {
  display: flex; align-items: center; gap: 5px;
  padding: 3px 7px;
  border-radius: 5px;
  margin-bottom: 3px;
  font-size: 11.5px;
  font-weight: 400;
  cursor: pointer;
  transition: filter .12s;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.event-pill:hover { filter: brightness(.94); }
.event-pill .ev-dot {
  width: 5px; height: 5px;
  border-radius: 50%;
  flex-shrink: 0;
}
.event-pill span { overflow: hidden; text-overflow: ellipsis; }
.more-events {
  font-size: 10.5px;
  color: var(--ink3);
  padding: 2px 6px;
  cursor: pointer;
}
.more-events:hover { color: var(--ink2); }

/* event colors */
.ev-work   { background: #dce8f8; color: #1e4f96; }
.ev-work   .ev-dot { background: #2563b8; }
.ev-personal { background: #d4f0e5; color: #14604a; }
.ev-personal .ev-dot { background: #1a7f5a; }
.ev-health { background: #fce7f3; color: #9d174d; }
.ev-health .ev-dot { background: #be185d; }
.ev-finance { background: #fef3c7; color: #92400e; }
.ev-finance .ev-dot { background: #b45309; }
.ev-social { background: #ccfbf1; color: #0d6e68; }
.ev-social .ev-dot { background: #0f766e; }
.ev-other  { background: #ede9fe; color: #5b21b6; }
.ev-other  .ev-dot { background: #7c3aed; }

/* task pills on calendar — dashed border style */
.task-pill {
  display: flex; align-items: center; gap: 5px;
  padding: 2px 7px;
  border-radius: 5px;
  margin-bottom: 3px;
  font-size: 11px;
  cursor: pointer;
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  border: 1.5px dashed;
  background: transparent;
  transition: filter .12s, background .12s;
  position: relative;
}
.task-pill:hover { filter: brightness(.94); }
.task-pill .tp-check {
  width: 10px; height: 10px;
  border-radius: 50%;
  border: 1.5px solid currentColor;
  flex-shrink: 0;
  display: flex; align-items: center; justify-content: center;
}
.task-pill.done-pill { opacity: .5; }
.task-pill.done-pill .tp-check::after {
  content:'';
  width:5px; height:3px;
  border-left:1.5px solid currentColor;
  border-bottom:1.5px solid currentColor;
  transform:rotate(-45deg) translateY(-1px);
  display:block;
}
.task-pill span { overflow: hidden; text-overflow: ellipsis; }
.task-pill.work-pill   { border-color:#2563b8; color:#1e4f96; }
.task-pill.personal-pill { border-color:#1a7f5a; color:#14604a; }
.task-pill.health-pill { border-color:#be185d; color:#9d174d; }
.task-pill.finance-pill{ border-color:#b45309; color:#92400e; }
.task-pill.social-pill { border-color:#0f766e; color:#0d6e68; }
.task-pill.other-pill  { border-color:#7c3aed; color:#5b21b6; }

/* day detail task items */
.detail-task-item {
  display: flex; gap: 10px;
  padding: 9px 12px;
  border-radius: var(--radius-sm);
  margin-bottom: 7px;
  border: 1.5px dashed var(--border2);
  background: var(--surface);
  cursor: pointer;
  transition: all .15s;
  position: relative;
  overflow: hidden;
}
.detail-task-item::before {
  content: '';
  position: absolute;
  left: 0; top: 0; bottom: 0;
  width: 3px;
}
.detail-task-item.work::before { background: #2563b8; }
.detail-task-item.personal::before { background: #1a7f5a; }
.detail-task-item.health::before { background: #be185d; }
.detail-task-item.finance::before { background: #b45309; }
.detail-task-item.social::before { background: #0f766e; }
.detail-task-item.other::before { background: #7c3aed; }
.detail-task-item:hover { border-color: var(--border2); border-style: solid; box-shadow: var(--shadow); }
.detail-task-item.done-task { opacity: .55; }
.detail-task-check {
  width: 16px; height: 16px;
  border-radius: 50%;
  border: 1.5px solid var(--border2);
  flex-shrink: 0; margin-top: 1px;
  display: flex; align-items: center; justify-content: center;
  cursor: pointer; transition: all .2s;
}
.detail-task-check:hover { border-color: var(--green); }
.detail-task-check.checked { background: var(--green); border-color: var(--green); }
.detail-task-check.checked::after {
  content:'';
  width:8px; height:4px;
  border-left:2px solid #fff;
  border-bottom:2px solid #fff;
  transform:rotate(-45deg) translateY(-1px);
  display:block;
}
.detail-section-sep {
  font-size:10px; font-weight:600;
  text-transform:uppercase; letter-spacing:.1em;
  color:var(--ink3);
  margin: 12px 0 8px;
  display:flex; align-items:center; gap:6px;
}
.detail-section-sep::after {
  content:''; flex:1; height:1px; background:var(--border);
}

/* ─── DAY DETAIL SIDEBAR ──────────────────────────────── */
.day-detail {
  width: 280px;
  border-left: 1px solid var(--border);
  background: var(--surface);
  display: flex;
  flex-direction: column;
  overflow: hidden;
}
.day-detail-header {
  padding: 18px 18px 14px;
  border-bottom: 1px solid var(--border);
}
.day-detail-date {
  font-family: var(--serif);
  font-size: 28px;
  color: var(--ink);
  line-height: 1;
}
.day-detail-weekday {
  font-size: 12px;
  color: var(--ink3);
  margin-top: 2px;
  text-transform: uppercase;
  letter-spacing: .08em;
}
.day-detail-events { flex: 1; overflow-y: auto; padding: 12px 16px; }
.detail-ev-item {
  display: flex; gap: 10px;
  padding: 10px 12px;
  border-radius: var(--radius-sm);
  margin-bottom: 8px;
  border: 1px solid var(--border);
  background: var(--surface);
  cursor: pointer;
  transition: all .15s;
  position: relative;
  overflow: hidden;
}
.detail-ev-item::before {
  content: '';
  position: absolute;
  left: 0; top: 0; bottom: 0;
  width: 3px;
}
.detail-ev-item.ev-work::before { background: #2563b8; }
.detail-ev-item.ev-personal::before { background: #1a7f5a; }
.detail-ev-item.ev-health::before { background: #be185d; }
.detail-ev-item.ev-finance::before { background: #b45309; }
.detail-ev-item.ev-social::before { background: #0f766e; }
.detail-ev-item.ev-other::before { background: #7c3aed; }
.detail-ev-item:hover { border-color: var(--border2); box-shadow: var(--shadow); }
.detail-ev-info { flex: 1; min-width: 0; }
.detail-ev-name { font-size: 13px; font-weight: 500; color: var(--ink); margin-bottom: 2px; }
.detail-ev-time { font-size: 11px; color: var(--ink3); }
.detail-ev-delete {
  background: transparent;
  color: var(--ink3);
  font-size: 14px;
  padding: 2px 4px;
  border-radius: 4px;
  opacity: 0;
  transition: opacity .12s;
}
.detail-ev-item:hover .detail-ev-delete { opacity: 1; }
.detail-ev-delete:hover { background: #fee2e2; color: #b91c1c; }

.empty-state {
  text-align: center;
  padding: 30px 16px;
  color: var(--ink3);
}
.empty-icon { font-size: 32px; margin-bottom: 8px; }
.empty-text { font-size: 13px; }

.add-ev-quick {
  margin: 12px 16px;
  padding: 10px 14px;
  border: 1.5px dashed var(--border2);
  border-radius: var(--radius-sm);
  background: transparent;
  color: var(--ink3);
  font-size: 13px;
  text-align: center;
  cursor: pointer;
  transition: all .15s;
  width: calc(100% - 32px);
}
.add-ev-quick:hover { border-color: var(--ink2); color: var(--ink2); background: var(--surface2); }

/* ─── TASKS PANEL ──────────────────────────────── */
.tasks-panel { display: flex; flex: 1; overflow: hidden; }
.tasks-main { flex: 1; overflow-y: auto; padding: 20px 24px; }
.tasks-sidebar-right {
  width: 280px;
  border-left: 1px solid var(--border);
  background: var(--surface);
  overflow-y: auto;
  padding: 18px;
}

.tasks-header { display: flex; align-items: center; gap: 10px; margin-bottom: 18px; }
.tasks-header h2 {
  font-family: var(--serif);
  font-size: 22px; flex: 1;
}
.filter-row { display: flex; gap: 6px; margin-bottom: 18px; flex-wrap: wrap; }
.filter-chip {
  padding: 5px 13px;
  border-radius: 20px;
  font-size: 12px;
  font-weight: 500;
  border: 1px solid var(--border2);
  background: var(--surface);
  color: var(--ink2);
  cursor: pointer;
  transition: all .15s;
  display: flex; align-items: center; gap: 5px;
}
.filter-chip:hover { border-color: var(--ink); color: var(--ink); }
.filter-chip.active { background: var(--ink); color: #fff; border-color: var(--ink); }

.add-task-bar {
  display: flex; gap: 8px;
  margin-bottom: 22px;
  background: var(--surface);
  border: 1px solid var(--border2);
  border-radius: var(--radius);
  padding: 8px 12px;
  align-items: center;
  box-shadow: var(--shadow);
  transition: box-shadow .15s, border-color .15s;
}
.add-task-bar:focus-within {
  border-color: var(--accent);
  box-shadow: 0 0 0 3px rgba(37,99,184,.1), var(--shadow);
}
.add-task-bar input {
  flex: 1;
  border: none;
  background: transparent;
  font-size: 14px;
  color: var(--ink);
}
.add-task-bar input::placeholder { color: var(--ink3); }
.add-task-selects { display: flex; gap: 6px; }
.add-task-selects select {
  border: 1px solid var(--border);
  background: var(--surface2);
  border-radius: 6px;
  padding: 4px 8px;
  font-size: 12px;
  color: var(--ink2);
  cursor: pointer;
}
.add-task-selects select:focus { border-color: var(--accent); }
.btn-add-task {
  padding: 6px 14px;
  background: var(--ink);
  color: #fff;
  border-radius: var(--radius-sm);
  font-size: 13px;
  font-weight: 500;
  white-space: nowrap;
  transition: background .15s;
}
.btn-add-task:hover { background: #2d2c2a; }

/* TASK SECTIONS */
.task-section { margin-bottom: 24px; }
.task-section-title {
  display: flex; align-items: center; gap: 8px;
  font-size: 11px; font-weight: 600;
  text-transform: uppercase; letter-spacing: .1em;
  color: var(--ink3);
  margin-bottom: 10px;
  padding-bottom: 8px;
  border-bottom: 1px solid var(--border);
}
.task-section-title .section-count {
  background: var(--surface3);
  color: var(--ink3);
  border-radius: 20px;
  padding: 1px 7px;
  font-size: 10px;
}

.task-item {
  display: flex; align-items: flex-start; gap: 12px;
  padding: 12px 14px;
  background: var(--surface);
  border: 1px solid var(--border);
  border-radius: var(--radius-sm);
  margin-bottom: 7px;
  cursor: pointer;
  transition: all .15s var(--ease);
  position: relative;
}
.task-item:hover {
  border-color: var(--border2);
  box-shadow: var(--shadow);
  transform: translateY(-1px);
}
.task-item.done { opacity: .65; }
.task-item.done:hover { transform: none; box-shadow: none; }
.task-prio-bar {
  position: absolute; left: 0; top: 0; bottom: 0;
  width: 3px; border-radius: 3px 0 0 3px;
}
.prio-high { background: var(--rose); }
.prio-medium { background: var(--amber); }
.prio-low { background: var(--green); }

.task-check {
  width: 18px; height: 18px;
  border-radius: 50%;
  border: 1.5px solid var(--border2);
  flex-shrink: 0;
  margin-top: 1px;
  display: flex; align-items: center; justify-content: center;
  cursor: pointer;
  transition: all .2s var(--ease);
  background: transparent;
}
.task-check:hover { border-color: var(--green); }
.task-check.checked {
  background: var(--green);
  border-color: var(--green);
}
.task-check.checked::after {
  content: '';
  width: 9px; height: 5px;
  border-left: 2px solid #fff;
  border-bottom: 2px solid #fff;
  transform: rotate(-45deg) translateY(-1px);
  display: block;
}

.task-body { flex: 1; min-width: 0; }
.task-name {
  font-size: 14px;
  color: var(--ink);
  margin-bottom: 5px;
  font-weight: 400;
  transition: all .15s;
}
.task-item.done .task-name {
  text-decoration: line-through;
  color: var(--ink3);
}
.task-meta { display: flex; align-items: center; gap: 8px; flex-wrap: wrap; }
.task-tag {
  font-size: 11px; font-weight: 500;
  padding: 2px 8px; border-radius: 20px;
  display: inline-flex; align-items: center; gap: 4px;
}
.tag-work    { background: var(--accent-l); color: var(--accent-t); }
.tag-personal{ background: var(--green-l);  color: var(--green); }
.tag-health  { background: var(--rose-l);   color: var(--rose); }
.tag-finance { background: var(--amber-l);  color: var(--amber); }
.tag-social  { background: var(--teal-l);   color: var(--teal); }
.tag-other   { background: #ede9fe; color: #5b21b6; }

.task-date { font-size: 11px; color: var(--ink3); display: flex; align-items: center; gap: 3px; }
.task-date.overdue { color: var(--rose); }
.prio-badge {
  font-size: 10px; font-weight: 600;
  padding: 2px 7px; border-radius: 4px;
  text-transform: uppercase; letter-spacing: .06em;
}
.prio-badge.high   { background: var(--rose-l);  color: var(--rose); }
.prio-badge.medium { background: var(--amber-l); color: var(--amber); }
.prio-badge.low    { background: var(--green-l); color: var(--green); }

.task-actions {
  display: flex; gap: 4px;
  opacity: 0;
  transition: opacity .12s;
}
.task-item:hover .task-actions { opacity: 1; }
.task-action-btn {
  width: 26px; height: 26px;
  border-radius: 6px;
  background: transparent;
  color: var(--ink3);
  font-size: 14px;
  display: flex; align-items: center; justify-content: center;
  transition: all .12s;
}
.task-action-btn:hover { background: var(--surface2); color: var(--ink); }
.task-action-btn.del:hover { background: #fee2e2; color: #b91c1c; }

/* TASKS SIDEBAR STATS */
.stat-card {
  background: var(--surface2);
  border-radius: var(--radius-sm);
  padding: 14px;
  margin-bottom: 12px;
}
.stat-card-title {
  font-size: 11px; font-weight: 600;
  text-transform: uppercase; letter-spacing: .08em;
  color: var(--ink3);
  margin-bottom: 12px;
}
.stat-num {
  font-family: var(--serif);
  font-size: 36px;
  color: var(--ink);
  line-height: 1;
  margin-bottom: 4px;
}
.stat-sub { font-size: 12px; color: var(--ink3); }
.progress-wrap { margin-top: 10px; }
.progress-label {
  display: flex; justify-content: space-between;
  font-size: 11px; color: var(--ink3);
  margin-bottom: 5px;
}
.progress-track {
  height: 5px;
  background: var(--surface3);
  border-radius: 10px;
  overflow: hidden;
}
.progress-fill {
  height: 100%;
  background: var(--green);
  border-radius: 10px;
  transition: width .6s var(--ease);
}

.cat-row {
  display: flex; align-items: center; gap: 8px;
  margin-bottom: 8px;
}
.cat-dot { width: 8px; height: 8px; border-radius: 50%; flex-shrink: 0; }
.cat-name { font-size: 12px; color: var(--ink2); flex: 1; }
.cat-count { font-size: 12px; font-weight: 500; color: var(--ink); }
.cat-bar-wrap { width: 60px; height: 4px; background: var(--surface3); border-radius: 3px; overflow: hidden; }
.cat-bar { height: 100%; border-radius: 3px; transition: width .5s var(--ease); }

/* ─── MODAL ──────────────────────────────── */
.modal-overlay {
  position: fixed; inset: 0;
  background: rgba(0,0,0,.4);
  backdrop-filter: blur(4px);
  z-index: 200;
  display: flex;
  align-items: center; justify-content: center;
  opacity: 0; pointer-events: none;
  transition: opacity .2s;
}
.modal-overlay.open { opacity: 1; pointer-events: all; }
.modal {
  background: var(--surface);
  border-radius: var(--radius);
  padding: 24px;
  width: 420px;
  box-shadow: var(--shadow-l);
  transform: scale(.96) translateY(8px);
  transition: transform .2s var(--ease);
  max-height: 90vh;
  overflow-y: auto;
}
.modal-overlay.open .modal { transform: scale(1) translateY(0); }
.modal-header {
  display: flex; align-items: center; justify-content: space-between;
  margin-bottom: 20px;
}
.modal-title {
  font-family: var(--serif);
  font-size: 20px; color: var(--ink);
}
.modal-close {
  width: 30px; height: 30px;
  border-radius: var(--radius-sm);
  background: var(--surface2);
  color: var(--ink2);
  font-size: 18px;
  display: flex; align-items: center; justify-content: center;
  cursor: pointer; border: none;
  transition: all .12s;
}
.modal-close:hover { background: #fee2e2; color: #b91c1c; }
.form-group { margin-bottom: 16px; }
.form-label {
  display: block;
  font-size: 12px; font-weight: 500;
  color: var(--ink2);
  margin-bottom: 6px;
  text-transform: uppercase; letter-spacing: .06em;
}
.form-input {
  width: 100%;
  padding: 9px 12px;
  border: 1px solid var(--border2);
  border-radius: var(--radius-sm);
  font-size: 14px;
  color: var(--ink);
  background: var(--surface);
  transition: border-color .15s, box-shadow .15s;
}
.form-input:focus {
  border-color: var(--accent);
  box-shadow: 0 0 0 3px rgba(37,99,184,.1);
}
.form-row { display: grid; grid-template-columns: 1fr 1fr; gap: 12px; }
.modal-actions { display: flex; gap: 8px; justify-content: flex-end; margin-top: 20px; }

/* ─── TOAST ──────────────────────────────── */
.toast {
  position: fixed;
  bottom: 24px; right: 24px;
  background: var(--ink);
  color: #fff;
  padding: 10px 16px;
  border-radius: var(--radius-sm);
  font-size: 13px;
  font-weight: 400;
  box-shadow: var(--shadow-l);
  z-index: 999;
  transform: translateY(20px);
  opacity: 0;
  transition: all .25s var(--ease);
}
.toast.show { transform: translateY(0); opacity: 1; }

/* ─── ANIMATIONS ──────────────────────────────── */
@keyframes fadeSlideIn {
  from { opacity: 0; transform: translateY(8px); }
  to   { opacity: 1; transform: translateY(0); }
}
.task-item, .cal-cell, .detail-ev-item {
  animation: fadeSlideIn .2s var(--ease) both;
}

/* ─── RESPONSIVE ──────────────────────────────── */
@media (max-width: 1100px) {
  .day-detail { display: none; }
  .tasks-sidebar-right { width: 220px; }
}
@media (max-width: 860px) {
  .app { grid-template-columns: 1fr; grid-template-rows: 56px 56px 1fr; }
  .sidebar { display: none; }
  .tasks-sidebar-right { display: none; }
}
</style>
</head>
<body>

<div class="app">

  <!-- ─── SIDEBAR ─── -->
  <aside class="sidebar">
    <div class="sidebar-brand">
      <div class="brand-icon">
        <svg viewBox="0 0 24 24"><path d="M19 4H5C3.89 4 3 4.9 3 6v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V6c0-1.1-.9-2-2-2zm-7 3c1.93 0 3.5 1.57 3.5 3.5S13.93 14 12 14s-3.5-1.57-3.5-3.5S10.07 7 12 7zm7 13H5v-.23c0-.62.28-1.2.76-1.58C7.47 17.18 9.64 16 12 16s4.53 1.18 6.24 2.19c.48.38.76.97.76 1.58V20z"/></svg>
      </div>
      <span class="brand-name">Agenda</span>
    </div>

    <nav class="sidebar-nav">
      <div class="nav-label">Visualização</div>
      <button class="nav-btn active" onclick="switchTab('calendar', this)">
        <svg viewBox="0 0 24 24" fill="currentColor"><path d="M20 3h-1V1h-2v2H7V1H5v2H4c-1.1 0-2 .9-2 2v16c0 1.1.9 2 2 2h16c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm0 18H4V8h16v13z"/></svg>
        Calendário
      </button>
      <button class="nav-btn" onclick="switchTab('tasks', this)">
        <svg viewBox="0 0 24 24" fill="currentColor"><path d="M19 3H5c-1.1 0-2 .9-2 2v14c0 1.1.9 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2zm-7 3c1.93 0 3.5 1.57 3.5 3.5S13.93 13 12 13s-3.5-1.57-3.5-3.5S10.07 6 12 6zm7 13H5v-.23c0-.62.28-1.2.76-1.58A9.956 9.956 0 0112 17c2.36 0 4.53 1.18 6.24 2.19.48.38.76.97.76 1.58V19z"/></svg>
        Tarefas
        <span class="nav-badge" id="badge-tasks">0</span>
      </button>

      <div class="nav-label">Categorias</div>
      <button class="nav-btn" onclick="filterNavCat('work')">
        <svg viewBox="0 0 24 24" fill="currentColor" style="color:#2563b8"><path d="M20 6h-2.18c.07-.44.18-.87.18-1.33C18 2.54 15.96.5 13.5.5c-1.33 0-2.51.58-3.34 1.5L9 3.5l-1.16-1.5C6.99 1.08 5.81.5 4.5.5 2.04.5 0 2.54 0 5c0 .46.11.87.18 1.33H0v2h2v12h20V8h-2V6zm-6.5-4c1.1 0 2 .9 2 2 0 .84-.53 1.55-1.29 1.84L12 7.5l-2.21-1.66C9.03 5.55 8.5 4.84 8.5 4c0-1.1.9-2 2-2s2 .9 2 2c0-.34-.08-.66-.21-.95.06.01.14.45.21.95z"/></svg>
        Trabalho
      </button>
      <button class="nav-btn" onclick="filterNavCat('personal')">
        <svg viewBox="0 0 24 24" fill="currentColor" style="color:#1a7f5a"><path d="M12 12c2.21 0 4-1.79 4-4s-1.79-4-4-4-4 1.79-4 4 1.79 4 4 4zm0 2c-2.67 0-8 1.34-8 4v2h16v-2c0-2.66-5.33-4-8-4z"/></svg>
        Pessoal
      </button>
      <button class="nav-btn" onclick="filterNavCat('health')">
        <svg viewBox="0 0 24 24" fill="currentColor" style="color:#be185d"><path d="M12 21.35l-1.45-1.32C5.4 15.36 2 12.27 2 8.5 2 5.41 4.42 3 7.5 3c1.74 0 3.41.81 4.5 2.08C13.09 3.81 14.76 3 16.5 3 19.58 3 22 5.41 22 8.5c0 3.77-3.4 6.86-8.55 11.53L12 21.35z"/></svg>
        Saúde
      </button>
      <button class="nav-btn" onclick="filterNavCat('finance')">
        <svg viewBox="0 0 24 24" fill="currentColor" style="color:#b45309"><path d="M11.8 10.9c-2.27-.59-3-1.2-3-2.15 0-1.09 1.01-1.85 2.7-1.85 1.78 0 2.44.85 2.5 2.1h2.21c-.07-1.72-1.12-3.3-3.21-3.81V3h-3v2.16c-1.94.42-3.5 1.68-3.5 3.61 0 2.31 1.91 3.46 4.7 4.13 2.5.6 3 1.48 3 2.41 0 .69-.49 1.79-2.7 1.79-2.06 0-2.87-.92-2.98-2.1h-2.2c.12 2.19 1.76 3.42 3.68 3.83V21h3v-2.15c1.95-.37 3.5-1.5 3.5-3.55 0-2.84-2.43-3.81-4.7-4.4z"/></svg>
        Finanças
      </button>
    </nav>

    <div class="sidebar-mini-cal">
      <div class="mini-cal-header">
        <span class="mini-cal-title" id="mini-title">Set 2025</span>
        <div class="mini-nav">
          <button class="mini-nav-btn" onclick="changeMonth(-1)" title="Mês anterior">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="15 18 9 12 15 6"/></svg>
          </button>
          <button class="mini-nav-btn" onclick="changeMonth(1)" title="Próximo mês">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.5" stroke-linecap="round" stroke-linejoin="round"><polyline points="9 18 15 12 9 6"/></svg>
          </button>
        </div>
      </div>
      <div class="mini-grid" id="mini-grid"></div>
    </div>
  </aside>

  <!-- ─── TOPBAR ─── -->
  <header class="topbar">
    <div class="topbar-title" id="topbar-title">
      Setembro <span>2025</span>
    </div>
    <div class="topbar-actions">
      <div class="view-switcher" id="view-switcher-cal">
        <button class="view-btn active" onclick="setView('month',this)">Mês</button>
        <button class="view-btn" onclick="setView('week',this)">Semana</button>
      </div>
      <div class="cal-nav-group" id="topbar-cal-nav">
        <button class="cal-nav-btn prev" onclick="changeMonth(-1)" title="Mês anterior" aria-label="Mês anterior">
          <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"><polyline points="15 18 9 12 15 6"/></svg>
        </button>
        <button class="today-pill" onclick="goToday()">Hoje</button>
        <button class="cal-nav-btn next" onclick="changeMonth(1)" title="Próximo mês" aria-label="Próximo mês">
          <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2.2" stroke-linecap="round" stroke-linejoin="round"><polyline points="9 18 15 12 9 6"/></svg>
        </button>
      </div>
      <button class="btn btn-primary" onclick="openModal()">
        <svg viewBox="0 0 24 24" fill="currentColor"><path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"/></svg>
        Novo evento
      </button>
    </div>
  </header>

  <!-- ─── MAIN ─── -->
  <main class="main">

    <!-- CALENDAR PANEL -->
    <div class="panel active" id="panel-calendar">
      <div class="cal-wrap">
        <div class="cal-body">
          <div class="cal-nav" id="cal-nav" style="display:none">
            <h2 class="cal-month-title" id="cal-month-label"></h2>
            <div class="cal-nav-btns">
              <button class="cal-nav-btn" onclick="changeMonth(-1)">‹</button>
              <button class="today-pill" onclick="goToday()">Hoje</button>
              <button class="cal-nav-btn" onclick="changeMonth(1)">›</button>
            </div>
          </div>
          <div class="dow-row" id="dow-row"></div>
          <div class="cal-grid-scroll">
            <div class="cal-grid" id="cal-grid"></div>
          </div>
        </div>
        <div class="day-detail" id="day-detail">
          <div class="day-detail-header">
            <div>
              <div class="day-detail-date" id="detail-date">1</div>
              <div class="day-detail-weekday" id="detail-weekday">Segunda-feira</div>
            </div>
          </div>
          <div class="day-detail-events" id="detail-events"></div>
          <button class="add-ev-quick" onclick="openModal()">+ Adicionar evento</button>
        </div>
      </div>
    </div>

    <!-- TASKS PANEL -->
    <div class="panel" id="panel-tasks">
      <div class="tasks-panel">
        <div class="tasks-main">
          <div class="tasks-header">
            <h2>Minhas Tarefas</h2>
            <button class="btn btn-primary" onclick="openTaskModal()">
              <svg viewBox="0 0 24 24" fill="currentColor" style="width:14px;height:14px"><path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"/></svg>
              Nova tarefa
            </button>
          </div>
          <div class="filter-row" id="task-filters">
            <button class="filter-chip active" data-filter="all" onclick="applyFilter('all',this)">Todas</button>
            <button class="filter-chip" data-filter="work" onclick="applyFilter('work',this)">💼 Trabalho</button>
            <button class="filter-chip" data-filter="personal" onclick="applyFilter('personal',this)">🙂 Pessoal</button>
            <button class="filter-chip" data-filter="health" onclick="applyFilter('health',this)">❤ Saúde</button>
            <button class="filter-chip" data-filter="finance" onclick="applyFilter('finance',this)">💰 Finanças</button>
            <button class="filter-chip" data-filter="social" onclick="applyFilter('social',this)">🤝 Social</button>
          </div>
          <div class="add-task-bar">
            <svg viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" style="width:16px;height:16px;color:var(--ink3);flex-shrink:0"><path d="M12 5v14M5 12h14"/></svg>
            <input type="text" id="quick-task-input" placeholder="Adicionar tarefa rapidamente… (Enter para salvar)" onkeydown="if(event.key==='Enter')quickAddTask()"/>
            <div class="add-task-selects">
              <select id="quick-cat">
                <option value="work">Trabalho</option>
                <option value="personal">Pessoal</option>
                <option value="health">Saúde</option>
                <option value="finance">Finanças</option>
                <option value="social">Social</option>
                <option value="other">Outro</option>
              </select>
              <select id="quick-prio">
                <option value="medium">Média</option>
                <option value="high">Alta</option>
                <option value="low">Baixa</option>
              </select>
            </div>
            <button class="btn-add-task" onclick="quickAddTask()">Adicionar</button>
          </div>
          <div id="tasks-container"></div>
        </div>
        <div class="tasks-sidebar-right">
          <div class="stat-card">
            <div class="stat-card-title">Progresso hoje</div>
            <div class="stat-num" id="s-done">0</div>
            <div class="stat-sub">tarefas concluídas</div>
            <div class="progress-wrap">
              <div class="progress-label">
                <span id="s-pct-label">0 de 0</span>
                <span id="s-pct">0%</span>
              </div>
              <div class="progress-track">
                <div class="progress-fill" id="s-bar" style="width:0%"></div>
              </div>
            </div>
          </div>
          <div class="stat-card">
            <div class="stat-card-title">Por categoria</div>
            <div id="cat-stats"></div>
          </div>
          <div class="stat-card">
            <div class="stat-card-title">Prioridade Alta</div>
            <div id="high-prio-items" style="font-size:12px;color:var(--ink3)">Nenhuma</div>
          </div>
          <div class="stat-card">
            <div class="stat-card-title">Pendentes</div>
            <div class="stat-num" id="s-pending" style="font-size:28px">0</div>
            <div class="stat-sub">aguardando conclusão</div>
          </div>
        </div>
      </div>
    </div>

  </main>
</div>

<!-- ─── EVENT MODAL ─── -->
<div class="modal-overlay" id="event-modal">
  <div class="modal">
    <div class="modal-header">
      <span class="modal-title">Novo Evento</span>
      <button class="modal-close" onclick="closeModal()">×</button>
    </div>
    <div class="form-group">
      <label class="form-label">Nome do evento</label>
      <input class="form-input" id="ev-name" type="text" placeholder="Ex: Reunião de equipe, Consulta médica…"/>
    </div>
    <div class="form-row">
      <div class="form-group">
        <label class="form-label">Data</label>
        <input class="form-input" id="ev-date" type="date"/>
      </div>
      <div class="form-group">
        <label class="form-label">Horário</label>
        <input class="form-input" id="ev-time" type="time" value="09:00"/>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group">
        <label class="form-label">Categoria</label>
        <select class="form-input" id="ev-cat">
          <option value="work">Trabalho</option>
          <option value="personal">Pessoal</option>
          <option value="health">Saúde</option>
          <option value="finance">Finanças</option>
          <option value="social">Social</option>
          <option value="other">Outro</option>
        </select>
      </div>
      <div class="form-group">
        <label class="form-label">Duração</label>
        <select class="form-input" id="ev-dur">
          <option value="30">30 min</option>
          <option value="60" selected>1 hora</option>
          <option value="90">1h30</option>
          <option value="120">2 horas</option>
          <option value="0">Dia todo</option>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="form-label">Notas (opcional)</label>
      <textarea class="form-input" id="ev-notes" rows="2" placeholder="Detalhes adicionais…" style="resize:vertical"></textarea>
    </div>
    <div class="modal-actions">
      <button class="btn btn-ghost" onclick="closeModal()">Cancelar</button>
      <button class="btn btn-primary" onclick="saveEvent()">Salvar evento</button>
    </div>
  </div>
</div>

<!-- ─── TASK MODAL ─── -->
<div class="modal-overlay" id="task-modal">
  <div class="modal">
    <div class="modal-header">
      <span class="modal-title">Nova Tarefa</span>
      <button class="modal-close" onclick="closeTaskModal()">×</button>
    </div>
    <div class="form-group">
      <label class="form-label">Nome da tarefa</label>
      <input class="form-input" id="t-name" type="text" placeholder="O que precisa ser feito?"/>
    </div>
    <div class="form-row">
      <div class="form-group">
        <label class="form-label">Categoria</label>
        <select class="form-input" id="t-cat">
          <option value="work">Trabalho</option>
          <option value="personal">Pessoal</option>
          <option value="health">Saúde</option>
          <option value="finance">Finanças</option>
          <option value="social">Social</option>
          <option value="other">Outro</option>
        </select>
      </div>
      <div class="form-group">
        <label class="form-label">Prioridade</label>
        <select class="form-input" id="t-prio">
          <option value="high">🔴 Alta</option>
          <option value="medium" selected>🟡 Média</option>
          <option value="low">🟢 Baixa</option>
        </select>
      </div>
    </div>
    <div class="form-row">
      <div class="form-group">
        <label class="form-label">Prazo</label>
        <input class="form-input" id="t-date" type="date"/>
      </div>
      <div class="form-group">
        <label class="form-label">Estimativa</label>
        <select class="form-input" id="t-est">
          <option value="">Nenhuma</option>
          <option value="15min">15 min</option>
          <option value="30min">30 min</option>
          <option value="1h">1 hora</option>
          <option value="2h">2 horas</option>
          <option value="1d">1 dia</option>
        </select>
      </div>
    </div>
    <div class="form-group">
      <label class="form-label">Notas</label>
      <textarea class="form-input" id="t-notes" rows="2" placeholder="Detalhes, links, contexto…" style="resize:vertical"></textarea>
    </div>
    <div class="modal-actions">
      <button class="btn btn-ghost" onclick="closeTaskModal()">Cancelar</button>
      <button class="btn btn-primary" onclick="saveTask()">Criar tarefa</button>
    </div>
  </div>
</div>

<!-- TOAST -->
<div class="toast" id="toast"></div>

<script>
// ─── STATE ───────────────────────────────────────────
const today = new Date();
let viewYear = today.getFullYear();
let viewMonth = today.getMonth();
let selectedDate = new Date(today);
let currentFilter = 'all';
let currentTab = 'calendar';

const MONTHS = ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'];
const MONTHS_SHORT = ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'];
const WEEKDAYS = ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb'];
const WEEKDAYS_FULL = ['Domingo','Segunda-feira','Terça-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sábado'];
const CAT_COLORS = { work:'#2563b8', personal:'#1a7f5a', health:'#be185d', finance:'#b45309', social:'#0f766e', other:'#7c3aed' };
const CAT_LABELS = { work:'Trabalho', personal:'Pessoal', health:'Saúde', finance:'Finanças', social:'Social', other:'Outro' };
const PRIO_ORDER = { high:0, medium:1, low:2 };

// Seed events
let events = [
  { id:1, name:'Reunião de equipe', date: fmt(today,0,1), time:'09:00', cat:'work', dur:60 },
  { id:2, name:'Almoço com cliente', date: fmt(today,0,3), time:'12:30', cat:'social', dur:90 },
  { id:3, name:'Academia', date: fmt(today,0,0), time:'07:00', cat:'health', dur:60 },
  { id:4, name:'Revisão de relatório', date: fmt(today,0,5), time:'14:00', cat:'work', dur:60 },
  { id:5, name:'Consulta médica', date: fmt(today,0,8), time:'10:00', cat:'health', dur:30 },
  { id:6, name:'Pagamento de contas', date: fmt(today,0,-2), time:'11:00', cat:'finance', dur:30 },
  { id:7, name:'Jantar em família', date: fmt(today,0,4), time:'19:30', cat:'social', dur:120 },
  { id:8, name:'Treinamento', date: fmt(today,0,6), time:'15:00', cat:'work', dur:60 },
];

let tasks = [
  { id:1, name:'Preparar apresentação do projeto', cat:'work', prio:'high', done:false, date: fmt(today,0,2), est:'2h', notes:'' },
  { id:2, name:'Ir à academia 3x esta semana', cat:'health', prio:'medium', done:false, date: fmt(today,0,5), est:'1h', notes:'' },
  { id:3, name:'Revisar extrato bancário', cat:'finance', prio:'high', done:false, date: fmt(today,0,0), est:'30min', notes:'' },
  { id:4, name:'Ler 30 páginas do livro', cat:'personal', prio:'low', done:true, date: fmt(today,0,-1), est:'30min', notes:'' },
  { id:5, name:'Ligar para o médico', cat:'health', prio:'high', done:false, date: fmt(today,0,1), est:'15min', notes:'' },
  { id:6, name:'Enviar relatório mensal', cat:'work', prio:'high', done:false, date: fmt(today,0,3), est:'1h', notes:'' },
  { id:7, name:'Organizar reunião de equipe', cat:'work', prio:'medium', done:true, date: fmt(today,0,-3), est:'30min', notes:'' },
  { id:8, name:'Comprar mantimentos', cat:'personal', prio:'low', done:false, date: fmt(today,0,1), est:'1h', notes:'' },
  { id:9, name:'Pagar IPVA', cat:'finance', prio:'high', done:false, date: fmt(today,0,7), est:'15min', notes:'' },
  { id:10, name:'Fazer backup do computador', cat:'personal', prio:'medium', done:false, date: fmt(today,0,4), est:'30min', notes:'' },
];

let nextEvId = 20, nextTaskId = 20;

function fmt(d, monthOffset=0, dayOffset=0) {
  const nd = new Date(d.getFullYear(), d.getMonth() + monthOffset, d.getDate() + dayOffset);
  return nd.toISOString().slice(0,10);
}
function fmtDate(dateStr) {
  const [y,m,d] = dateStr.split('-');
  return new Date(+y,+m-1,+d);
}
function dateKey(d) { return d.toISOString().slice(0,10); }

// ─── TAB SWITCHING ──────────────────────────────────
function switchTab(tab, btn) {
  currentTab = tab;
  document.querySelectorAll('.panel').forEach(p => p.classList.remove('active'));
  document.getElementById('panel-'+tab).classList.add('active');
  document.querySelectorAll('.nav-btn').forEach(b => b.classList.remove('active'));
  if(btn) btn.classList.add('active');
  const topTitle = document.getElementById('topbar-title');
  const viewSwitcher = document.getElementById('view-switcher-cal');
  const newEvBtn = document.querySelector('.topbar .btn-primary');
  if(tab==='calendar') {
    updateTopTitle();
    viewSwitcher.style.display = 'flex';
    document.getElementById('topbar-cal-nav').style.display = 'flex';
    newEvBtn.textContent = ''; newEvBtn.innerHTML = '<svg viewBox="0 0 24 24" fill="currentColor" style="width:14px;height:14px"><path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"/></svg> Novo evento';
    newEvBtn.onclick = openModal;
  } else {
    topTitle.innerHTML = 'Tarefas <span>pendentes</span>';
    viewSwitcher.style.display = 'none';
    document.getElementById('topbar-cal-nav').style.display = 'none';
    newEvBtn.innerHTML = '<svg viewBox="0 0 24 24" fill="currentColor" style="width:14px;height:14px"><path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z"/></svg> Nova tarefa';
    newEvBtn.onclick = openTaskModal;
    renderTasks();
    renderTaskStats();
  }
}

function filterNavCat(cat) {
  switchTab('tasks', null);
  document.querySelectorAll('.nav-btn').forEach(b=>b.classList.remove('active'));
  applyFilter(cat, document.querySelector(`[data-filter="${cat}"]`));
}

// ─── CALENDAR ──────────────────────────────────────
function updateTopTitle() {
  document.getElementById('topbar-title').innerHTML = `${MONTHS[viewMonth]} <span>${viewYear}</span>`;
}

function changeMonth(dir) {
  viewMonth += dir;
  if(viewMonth>11){viewMonth=0;viewYear++;}
  if(viewMonth<0){viewMonth=11;viewYear--;}
  renderCalendar();
  renderMiniCal();
  updateTopTitle();
}

function goToday() {
  selectedDate = new Date(today);
  viewYear = today.getFullYear();
  viewMonth = today.getMonth();
  renderCalendar();
  renderMiniCal();
  updateTopTitle();
  renderDayDetail(selectedDate);
}

function setView(v, btn) {
  document.querySelectorAll('.view-btn').forEach(b=>b.classList.remove('active'));
  btn.classList.add('active');
}

function renderCalendar() {
  const grid = document.getElementById('cal-grid');
  const dowRow = document.getElementById('dow-row');
  dowRow.innerHTML = '';
  WEEKDAYS.forEach(d => {
    const c = document.createElement('div');
    c.className = 'dow-cell'; c.textContent = d;
    dowRow.appendChild(c);
  });

  const firstDay = new Date(viewYear, viewMonth, 1).getDay();
  const daysInMonth = new Date(viewYear, viewMonth+1, 0).getDate();
  const daysInPrev = new Date(viewYear, viewMonth, 0).getDate();

  grid.innerHTML = '';
  const todayKey = dateKey(today);
  const selKey = dateKey(selectedDate);
  const evMap = buildEvMap();
  const taskMap = buildTaskMap();

  let cells = [];
  for(let i=firstDay-1;i>=0;i--) cells.push({ d: daysInPrev-i, m:'prev' });
  for(let i=1;i<=daysInMonth;i++) cells.push({ d:i, m:'curr' });
  while(cells.length%7!==0) cells.push({ d:cells.length-firstDay-daysInMonth+1, m:'next' });

  cells.forEach(({d,m}) => {
    let cellDate;
    if(m==='prev') cellDate = new Date(viewYear, viewMonth-1, d);
    else if(m==='next') cellDate = new Date(viewYear, viewMonth+1, d);
    else cellDate = new Date(viewYear, viewMonth, d);

    const key = dateKey(cellDate);
    const cell = document.createElement('div');
    cell.className = 'cal-cell' + (m!=='curr'?' other-month':'') + (key===todayKey?' today':'') + (key===selKey?' selected':'');
    cell.onclick = () => selectDay(cellDate);

    const dn = document.createElement('div');
    dn.className = 'day-num'; dn.textContent = d;
    cell.appendChild(dn);

    const dayEvs = evMap[key]||[];
    const dayTasks = taskMap[key]||[];
    const totalItems = dayEvs.length + dayTasks.length;
    let shown = 0;
    const MAX = 3;

    dayEvs.forEach(ev => {
      if(shown >= MAX) return;
      const pill = document.createElement('div');
      pill.className = `event-pill ev-${ev.cat}`;
      pill.innerHTML = `<span class="ev-dot"></span><span>${ev.time ? ev.time+' ' : ''}${ev.name}</span>`;
      pill.onclick = e => { e.stopPropagation(); selectDay(cellDate); };
      cell.appendChild(pill);
      shown++;
    });

    dayTasks.forEach(t => {
      if(shown >= MAX) return;
      const pill = document.createElement('div');
      pill.className = `task-pill ${t.cat}-pill${t.done?' done-pill':''}`;
      pill.title = t.done ? 'Concluída' : 'Pendente — clique para concluir';
      pill.innerHTML = `<span class="tp-check${t.done?' checked':''}"></span><span>${t.name}</span>`;
      pill.onclick = e => { e.stopPropagation(); toggleTask(t.id, e); renderCalendar(); renderMiniCal(); };
      cell.appendChild(pill);
      shown++;
    });

    const remaining = totalItems - shown;
    if(remaining > 0) {
      const more = document.createElement('div');
      more.className = 'more-events';
      more.textContent = `+${remaining} mais`;
      cell.appendChild(more);
    }
    grid.appendChild(cell);
  });

  renderDayDetail(selectedDate);
}

function buildEvMap() {
  const map = {};
  events.forEach(ev => {
    if(!map[ev.date]) map[ev.date] = [];
    map[ev.date].push(ev);
  });
  return map;
}

function buildTaskMap() {
  const map = {};
  tasks.forEach(t => {
    if(!t.date) return;
    if(!map[t.date]) map[t.date] = [];
    map[t.date].push(t);
  });
  return map;
}

function selectDay(d) {
  selectedDate = d;
  viewYear = d.getFullYear(); viewMonth = d.getMonth();
  renderCalendar();
  renderMiniCal();
  updateTopTitle();
}

function renderDayDetail(d) {
  const key = dateKey(d);
  document.getElementById('detail-date').textContent = d.getDate();
  document.getElementById('detail-weekday').textContent = WEEKDAYS_FULL[d.getDay()] + ', ' + d.toLocaleDateString('pt-BR',{month:'long'});
  const container = document.getElementById('detail-events');
  const dayEvs = events.filter(e=>e.date===key).sort((a,b)=>a.time.localeCompare(b.time));
  const dayTasks = tasks.filter(t=>t.date===key).sort((a,b)=>PRIO_ORDER[a.prio]-PRIO_ORDER[b.prio]);

  if(dayEvs.length===0 && dayTasks.length===0) {
    container.innerHTML = `<div class="empty-state"><div class="empty-icon">📅</div><div class="empty-text">Nenhum evento ou tarefa neste dia</div></div>`;
    return;
  }
  container.innerHTML = '';

  if(dayEvs.length) {
    const sep = document.createElement('div');
    sep.className = 'detail-section-sep';
    sep.innerHTML = `<span>Eventos</span>`;
    container.appendChild(sep);
    dayEvs.forEach(ev => {
      const item = document.createElement('div');
      item.className = `detail-ev-item ev-${ev.cat}`;
      item.innerHTML = `
        <div class="detail-ev-info">
          <div class="detail-ev-name">${ev.name}</div>
          <div class="detail-ev-time">${ev.time}${ev.dur?' · '+formatDur(ev.dur):''} · ${CAT_LABELS[ev.cat]||ev.cat}</div>
          ${ev.notes?`<div style="font-size:11px;color:var(--ink3);margin-top:3px">${ev.notes}</div>`:''}
        </div>
        <button class="detail-ev-delete" onclick="deleteEvent(${ev.id},event)" title="Remover">×</button>
      `;
      container.appendChild(item);
    });
  }

  if(dayTasks.length) {
    const sep2 = document.createElement('div');
    sep2.className = 'detail-section-sep';
    sep2.innerHTML = `<span>Tarefas</span>`;
    container.appendChild(sep2);
    dayTasks.forEach(t => {
      const item = document.createElement('div');
      item.className = `detail-task-item ${t.cat}${t.done?' done-task':''}`;
      const overdue = t.date && !t.done && fmtDate(t.date) < today;
      item.innerHTML = `
        <div class="detail-task-check${t.done?' checked':''}" onclick="toggleTask(${t.id},event);renderCalendar();renderDayDetail(selectedDate);" title="${t.done?'Reabrir':'Concluir'}"></div>
        <div class="detail-ev-info">
          <div class="detail-ev-name" style="${t.done?'text-decoration:line-through;color:var(--ink3)':''}">${t.name}</div>
          <div class="detail-ev-time" style="display:flex;gap:6px;flex-wrap:wrap;margin-top:2px">
            <span class="task-tag tag-${t.cat}" style="font-size:10px;padding:1px 6px">${CAT_LABELS[t.cat]}</span>
            <span class="prio-badge ${t.prio}" style="font-size:10px">${t.prio==='high'?'Alta':t.prio==='medium'?'Média':'Baixa'}</span>
            ${overdue?'<span style="color:var(--rose);font-size:10px">Atrasada</span>':''}
          </div>
        </div>
        <button class="detail-ev-delete" onclick="deleteTask(${t.id},event);renderCalendar();renderDayDetail(selectedDate);" title="Remover">×</button>
      `;
      container.appendChild(item);
    });
  }
}

function formatDur(min) {
  if(min===0) return 'Dia todo';
  if(min<60) return min+'min';
  const h = Math.floor(min/60), m = min%60;
  return h+'h'+(m?m+'min':'');
}

function deleteEvent(id, e) {
  e.stopPropagation();
  events = events.filter(ev=>ev.id!==id);
  renderCalendar();
  showToast('Evento removido');
}

// ─── MINI CALENDAR ──────────────────────────────────
function renderMiniCal() {
  document.getElementById('mini-title').textContent = MONTHS_SHORT[viewMonth]+' '+viewYear;
  const grid = document.getElementById('mini-grid');
  grid.innerHTML = '';
  WEEKDAYS.forEach(d => {
    const c = document.createElement('div'); c.className = 'mini-dow'; c.textContent = d[0];
    grid.appendChild(c);
  });
  const firstDay = new Date(viewYear, viewMonth, 1).getDay();
  const daysInMonth = new Date(viewYear, viewMonth+1, 0).getDate();
  const daysInPrev = new Date(viewYear, viewMonth, 0).getDate();
  const todayKey = dateKey(today), selKey = dateKey(selectedDate);
  const evMap = buildEvMap();
  const taskMap2 = buildTaskMap();
  let cells = [];
  for(let i=firstDay-1;i>=0;i--) cells.push({d:daysInPrev-i,m:'prev'});
  for(let i=1;i<=daysInMonth;i++) cells.push({d:i,m:'curr'});
  while(cells.length%7!==0) cells.push({d:cells.length-firstDay-daysInMonth+1,m:'next'});
  cells.forEach(({d,m})=>{
    let cd;
    if(m==='prev') cd=new Date(viewYear,viewMonth-1,d);
    else if(m==='next') cd=new Date(viewYear,viewMonth+1,d);
    else cd=new Date(viewYear,viewMonth,d);
    const key=dateKey(cd);
    const el=document.createElement('div');
    el.className='mini-day'+(m!=='curr'?' other':'')+(key===todayKey?' today':'')+(key===selKey&&key!==todayKey?' selected':'');
    if((evMap[key]&&evMap[key].length)||(taskMap2[key]&&taskMap2[key].length)) el.classList.add('has-event');
    el.textContent=d;
    el.onclick=()=>selectDay(cd);
    grid.appendChild(el);
  });
}

// ─── EVENTS MODAL ──────────────────────────────────
function openModal() {
  const modal = document.getElementById('event-modal');
  document.getElementById('ev-name').value='';
  document.getElementById('ev-date').value=dateKey(selectedDate);
  document.getElementById('ev-time').value='09:00';
  document.getElementById('ev-notes').value='';
  modal.classList.add('open');
  setTimeout(()=>document.getElementById('ev-name').focus(),200);
}
function closeModal() { document.getElementById('event-modal').classList.remove('open'); }
function saveEvent() {
  const name = document.getElementById('ev-name').value.trim();
  if(!name) { document.getElementById('ev-name').focus(); return; }
  events.push({
    id: ++nextEvId,
    name,
    date: document.getElementById('ev-date').value,
    time: document.getElementById('ev-time').value,
    cat:  document.getElementById('ev-cat').value,
    dur:  +document.getElementById('ev-dur').value,
    notes:document.getElementById('ev-notes').value.trim()
  });
  closeModal();
  renderCalendar();
  renderMiniCal();
  showToast('Evento criado! 🎉');
}

// ─── TASKS ──────────────────────────────────────────
function applyFilter(f, btn) {
  currentFilter = f;
  document.querySelectorAll('.filter-chip').forEach(c=>c.classList.remove('active'));
  if(btn) btn.classList.add('active');
  renderTasks();
}

function renderTasks() {
  const container = document.getElementById('tasks-container');
  let filtered = currentFilter==='all' ? tasks : tasks.filter(t=>t.cat===currentFilter);
  filtered = filtered.sort((a,b) => {
    if(a.done!==b.done) return a.done?1:-1;
    return PRIO_ORDER[a.prio]-PRIO_ORDER[b.prio];
  });
  const pending = filtered.filter(t=>!t.done);
  const done = filtered.filter(t=>t.done);

  container.innerHTML = '';

  if(pending.length===0 && done.length===0) {
    container.innerHTML = `<div class="empty-state" style="padding:40px 20px"><div class="empty-icon">✅</div><div class="empty-text">Nenhuma tarefa encontrada.<br>Adicione uma nova acima!</div></div>`;
    return;
  }

  if(pending.length) {
    const sec = document.createElement('div'); sec.className='task-section';
    sec.innerHTML = `<div class="task-section-title">Pendentes <span class="section-count">${pending.length}</span></div>`;
    pending.forEach(t => sec.appendChild(buildTaskEl(t)));
    container.appendChild(sec);
  }
  if(done.length) {
    const sec = document.createElement('div'); sec.className='task-section';
    sec.innerHTML = `<div class="task-section-title">Concluídas <span class="section-count">${done.length}</span></div>`;
    done.forEach(t => sec.appendChild(buildTaskEl(t)));
    container.appendChild(sec);
  }

  renderBadge();
}

function buildTaskEl(t) {
  const el = document.createElement('div');
  el.className = 'task-item' + (t.done?' done':'');
  el.style.animationDelay = Math.random()*.1+'s';
  const overdue = t.date && !t.done && fmtDate(t.date)<today;
  el.innerHTML = `
    <div class="task-prio-bar prio-${t.prio}"></div>
    <div class="task-check${t.done?' checked':''}" onclick="toggleTask(${t.id},event)"></div>
    <div class="task-body">
      <div class="task-name">${t.name}</div>
      <div class="task-meta">
        <span class="task-tag tag-${t.cat}">${CAT_LABELS[t.cat]}</span>
        <span class="prio-badge ${t.prio}">${t.prio==='high'?'Alta':t.prio==='medium'?'Média':'Baixa'}</span>
        ${t.date?`<span class="task-date${overdue?' overdue':''}">📅 ${fmtDate(t.date).toLocaleDateString('pt-BR',{day:'2-digit',month:'short'})}</span>`:''}
        ${t.est?`<span class="task-date">⏱ ${t.est}</span>`:''}
      </div>
    </div>
    <div class="task-actions">
      <button class="task-action-btn del" onclick="deleteTask(${t.id},event)" title="Excluir">
        <svg viewBox="0 0 24 24" fill="currentColor" style="width:13px;height:13px"><path d="M6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zm3-9h2v7H9v-7zm4 0h2v7h-2v-7zM15.5 4l-1-1h-5l-1 1H5v2h14V4z"/></svg>
      </button>
    </div>
  `;
  return el;
}

function toggleTask(id, e) {
  e.stopPropagation();
  const t = tasks.find(t=>t.id===id);
  if(t) { t.done=!t.done; renderTasks(); renderTaskStats(); if(currentTab==='calendar'){ renderCalendar(); renderMiniCal(); renderDayDetail(selectedDate); } showToast(t.done?'Tarefa concluída! ✅':'Tarefa reaberta'); }
}
function deleteTask(id, e) {
  e.stopPropagation();
  tasks = tasks.filter(t=>t.id!==id);
  renderTasks(); renderTaskStats();
  if(currentTab==='calendar'){ renderCalendar(); renderMiniCal(); renderDayDetail(selectedDate); }
  showToast('Tarefa removida');
}

function quickAddTask() {
  const name = document.getElementById('quick-task-input').value.trim();
  if(!name) { document.getElementById('quick-task-input').focus(); return; }
  tasks.unshift({
    id:++nextTaskId, name,
    cat: document.getElementById('quick-cat').value,
    prio: document.getElementById('quick-prio').value,
    done: false, date: '', est: '', notes: ''
  });
  document.getElementById('quick-task-input').value = '';
  renderTasks(); renderTaskStats();
  if(currentTab==='calendar') { renderCalendar(); renderMiniCal(); renderDayDetail(selectedDate); }
  showToast('Tarefa adicionada!');
}

function renderTaskStats() {
  const total = tasks.length;
  const done = tasks.filter(t=>t.done).length;
  const pending = total-done;
  const pct = total ? Math.round(done/total*100) : 0;

  document.getElementById('s-done').textContent = done;
  document.getElementById('s-pending').textContent = pending;
  document.getElementById('s-pct-label').textContent = `${done} de ${total}`;
  document.getElementById('s-pct').textContent = pct+'%';
  document.getElementById('s-bar').style.width = pct+'%';
  renderBadge();

  // Cat stats
  const catStats = document.getElementById('cat-stats');
  catStats.innerHTML='';
  const cats = ['work','personal','health','finance','social','other'];
  cats.forEach(cat=>{
    const ct = tasks.filter(t=>t.cat===cat).length;
    if(!ct) return;
    const pct2 = Math.round(ct/total*100);
    catStats.innerHTML += `
      <div class="cat-row">
        <div class="cat-dot" style="background:${CAT_COLORS[cat]}"></div>
        <div class="cat-name">${CAT_LABELS[cat]}</div>
        <div class="cat-bar-wrap"><div class="cat-bar" style="width:${pct2}%;background:${CAT_COLORS[cat]}"></div></div>
        <div class="cat-count">${ct}</div>
      </div>`;
  });

  // High prio
  const hp = tasks.filter(t=>t.prio==='high'&&!t.done);
  const hpEl = document.getElementById('high-prio-items');
  if(!hp.length) { hpEl.innerHTML='<span style="color:var(--green);font-weight:500">✅ Tudo em dia!</span>'; return; }
  hpEl.innerHTML = hp.slice(0,4).map(t=>`
    <div style="display:flex;align-items:center;gap:6px;margin-bottom:7px;padding:6px 8px;background:var(--rose-l);border-radius:6px;cursor:pointer" onclick="toggleTask(${t.id},event)">
      <div style="width:6px;height:6px;border-radius:50%;background:var(--rose);flex-shrink:0"></div>
      <span style="font-size:12px;color:var(--ink);flex:1;overflow:hidden;text-overflow:ellipsis;white-space:nowrap">${t.name}</span>
    </div>`).join('');
}

function renderBadge() {
  const count = tasks.filter(t=>!t.done).length;
  document.getElementById('badge-tasks').textContent = count;
}

// ─── TASK MODAL ──────────────────────────────────────
function openTaskModal() {
  document.getElementById('t-name').value='';
  document.getElementById('t-date').value='';
  document.getElementById('t-notes').value='';
  document.getElementById('task-modal').classList.add('open');
  setTimeout(()=>document.getElementById('t-name').focus(),200);
}
function closeTaskModal() { document.getElementById('task-modal').classList.remove('open'); }
function saveTask() {
  const name = document.getElementById('t-name').value.trim();
  if(!name) { document.getElementById('t-name').focus(); return; }
  tasks.unshift({
    id:++nextTaskId, name,
    cat: document.getElementById('t-cat').value,
    prio: document.getElementById('t-prio').value,
    done: false,
    date: document.getElementById('t-date').value,
    est: document.getElementById('t-est').value,
    notes: document.getElementById('t-notes').value.trim()
  });
  closeTaskModal();
  renderTasks(); renderTaskStats();
  if(currentTab==='calendar') { renderCalendar(); renderMiniCal(); renderDayDetail(selectedDate); }
  showToast('Tarefa criada! ✨');
}

// ─── TOAST ──────────────────────────────────────────
let toastTimer;
function showToast(msg) {
  const t = document.getElementById('toast');
  t.textContent = msg; t.classList.add('show');
  clearTimeout(toastTimer);
  toastTimer = setTimeout(()=>t.classList.remove('show'), 2800);
}

// ─── KEYBOARD ──────────────────────────────────────
document.addEventListener('keydown', e => {
  if(e.key==='Escape') { closeModal(); closeTaskModal(); }
  if((e.ctrlKey||e.metaKey)&&e.key==='k') { openModal(); e.preventDefault(); }
});
document.getElementById('event-modal').addEventListener('click', e => { if(e.target.id==='event-modal') closeModal(); });
document.getElementById('task-modal').addEventListener('click', e => { if(e.target.id==='task-modal') closeTaskModal(); });

// ─── INIT ──────────────────────────────────────────
renderCalendar();
renderMiniCal();
renderTasks();
renderTaskStats();
updateTopTitle();
</script>
</body>
</html>