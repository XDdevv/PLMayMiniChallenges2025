# 📚 Scrollable Study Board – Jetpack Compose Challenge

Welcome to my submission for the **May 2025 Mini-Challenge** hosted by [Philipp Lackner's Mobile Dev Campus](https://pl-coding.com/campus)! This challenge was all about taking a chaotic list of study topics and turning it into a clean, scrollable, tappable, pinnable, and fully interactive UI using **Jetpack Compose**—without any third-party libraries.

---

## 🎯 Challenge Objective

> Tame a giant list of 50+ categorized study topics into a smooth and functional user experience with:
- Sticky headers
- Section navigation via subject chips
- Scroll progress tracking
- Pinning with limits
- Scroll-to-jump functionality
- FAB scroll-to-top
- Snackbar notifications
- Scroll state restoration

---

## 🖼️ Demo Preview

![Study Board Demo](Screencast-From-2025-05-15-14-33-45.gif)
---

## 🔧 Features Implemented

✅ **Gradient background**  
✅ **Sticky headers** grouped by subject  
✅ **Chips row** for subject-based scroll-to-section  
✅ **Edge-to-edge progress bar** that tracks scroll position  
✅ **Pinning system** (up to 5 items only, visually separated)  
✅ **FAB to scroll to top**, appears after first 10 items  
✅ **Snackbar** warning when nearing end of list  
✅ **Scroll state preservation** on navigation  
✅ **Detail screen** for each topic  
✅ **Smooth animations & state handling**  
✅ 100% **Jetpack Compose + Standard Android Libraries Only**

---

## 🧪 User Flow Demo (as per challenge requirements)

- Scroll through subject chips and tap the last one
- Smooth scroll to last subject's section
- Pin 5 items → try to pin a 6th → show snackbar error
- Tap a list item → navigate to detail screen → go back
- Tap FAB → scroll to top
- Unpin an item
- Manually scroll to bottom → show "Reaching the end..." snackbar

---

## 🧠 What I Learned

- Efficient state and scroll handling in **LazyColumn**
- Building **sticky headers** and **custom progress bars**
- Managing **scroll state across navigation**
- Enhancing UX with **conditional FABs** and **snackbars**
- Designing interactive UIs **without external dependencies**

---

## 💡 Tech Stack

- **Language:** Kotlin  
- **UI Framework:** Jetpack Compose  
- **Architecture:** State hoisting + Compose best practices  
- **Navigation:** `Navigation-Compose`  
- **No third-party libraries used**

---

## 📂 Source Code

Explore the full implementation here:  
🔗 [GitHub Repository](https://github.com/XDdevv/PLMayMiniChallenges2025)

---

## 🙌 Special Thanks

Shoutout to **Philipp Lackner** and the **Mobile Dev Campus** community for organizing this awesome challenge and helping us sharpen our Compose skills in real-world scenarios.

---

## 🚀 Ready to Dive In?

Clone, run, and explore how Compose can transform chaos into clean design:

```bash
git clone https://github.com/XDdevv/PLMayHardMiniChallenge2025.git
