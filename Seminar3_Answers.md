# Seminar 3 — Android Development Practice Solutions

This document contains answers for **Seminar 3** covering **Android Studio**, **Git & GitHub**, and **Activity, Fragments & Navigation**.

---

## Section 1 — Introduction to Android Studio

### 1. What is Android Studio, and what four core things does it bundle into one workspace?
**Answer:**
Android Studio is the official Integrated Development Environment (IDE) for Android application development built by Google and powered by JetBrains IntelliJ IDEA.
It bundles four core things into one workspace:
1. **Code Editor** (with intelligent code completion, refactoring, and syntax highlighting)
2. **Build System** (Gradle for building, dependency management, and packaging APK/AAB files)
3. **Emulator & Layout Inspector** (Android Virtual Device / AVD to test apps without physical devices)
4. **Debugging & Profiling Tools** (Logcat, CPU/Memory/Network profilers, and debugger)

---

### 2. Name three of the reasons the lecture gives for why developers love Android Studio, and briefly explain each.
**Answer:**
1. **Intelligent Code Completion & Refactoring:** Provides smart autocompletion (SmartType), context-aware suggestions, and instant code refactoring tools.
2. **Rich Visual Layout Editor & Live Previews:** Enables visual UI design (XML / Jetpack Compose previews) with real-time feedback without re-compiling the full app.
3. **Seamless Gradle Integration & Android Emulators:** Flexible build configuration for multi-device support, libraries, and built-in Android emulators with configurable hardware specs.

---

### 3. List, in order, the four steps to install Android Studio, and state the minimum RAM and free disk space recommended.
**Answer:**
**Installation Steps:**
1. Download the official installer package from `developer.android.com/studio` for your OS (Windows, macOS, or Linux).
2. Run the installer executable/dmg and follow the setup wizard to install core components.
3. Open Android Studio for the first time and complete the **Android Studio Setup Wizard** to download the latest Android SDK, SDK Build Tools, and Android Emulator.
4. Set up an Android Virtual Device (AVD) or connect a physical Android device with USB Debugging enabled.

**Hardware Recommendations:**
- **Minimum RAM:** 8 GB (16 GB or higher recommended).
- **Free Disk Space:** At least 8 GB of free disk space (for IDE, Android SDKs, and AVD emulator images).

---

### 4. When creating a new project, name four settings you must configure in the wizard, besides picking a starting template.
**Answer:**
1. **Name:** The title/display name of the app (e.g., `My First App`).
2. **Package name:** The unique identifier for the app in reverse domain style (e.g., `com.example.myapp`).
3. **Save location:** The directory on your local computer where project source files will be stored.
4. **Minimum SDK (Minimum API Level):** The lowest version of Android required to run the app (e.g., API 24: Android 7.0).

---

### 5. Name the six zones of the main Android Studio window, and for each write one sentence describing what it's used for.
**Answer:**
1. **Navigation Bar / Menu Bar:** Used to quickly navigate through files, run/debug commands, and access top-level IDE settings.
2. **Project Tool Window:** Displays the project directory structure, source code, resources, and Gradle build scripts.
3. **Editor Window:** Used to write, edit, and view code, layout XML files, and Compose UI previews.
4. **Tool Window Bar / Sidebar buttons:** Used to toggle various specialized tool windows such as Logcat, Git, Terminal, Gradle, and Emulator.
5. **Status Bar:** Displays ongoing background tasks, Gradle sync status, build warnings/errors, and current cursor position.
6. **Logcat / Output Panel:** Used to inspect system logs, runtime outputs, stack traces, and application crash reports in real time.

---

### 6. In the Android view of the Project panel, what do the manifests, kotlin+java, and res groups each contain?
**Answer:**
- **manifests:** Contains `AndroidManifest.xml`, which defines essential application metadata (permissions, activity declarations, app name, icon, and theme).
- **kotlin+java:** Contains all Kotlin (`.kt`) and Java (`.java`) source code files, organized by package names, including unit tests (`test`) and instrumentation tests (`androidTest`).
- **res:** Contains non-code application resources organized in subfolders:
  - `drawable/` (images/vector graphics)
  - `layout/` (XML UI layouts)
  - `values/` (strings, colors, themes/styles)
  - `mipmap/` (launcher icons)

---

### 7. What's the difference between Basic completion (Ctrl+Space) and Smart completion (Ctrl+Shift+Space)?
**Answer:**
- **Basic Completion (`Ctrl + Space`):** Suggests all available class names, methods, variables, and keywords matching the typed prefix, regardless of type compatibility.
- **Smart Completion (`Ctrl + Shift + Space`):** Filters suggestions to show **only** items, variables, and functions that strictly match the expected return or target type in the current expression context.

---

### 8. During a debug session, what does setting a breakpoint and running in Debug mode let you do that simply hitting Run does not?
**Answer:**
Running in Debug mode with breakpoints pauses execution at specific code lines, allowing you to:
- Inspect current variable values and object states in memory.
- Evaluate custom expressions dynamically (`Evaluate Expression`).
- Step through execution line-by-line (`Step Over`, `Step Into`, `Step Out`).
- Callstack tracking and thread inspection without adding print statements.

---

### 9. Name three of the five key tool windows covered in the lecture, and the keyboard shortcut for each (where one exists).
**Answer:**
1. **Project Window:** `Alt + 1` (Windows/Linux) / `Cmd + 1` (macOS).
2. **Logcat Window:** `Alt + 6` (Windows/Linux) / `Cmd + 6` (macOS).
3. **Terminal Window:** `Alt + F12` (Windows/Linux) / `Option + F12` (macOS).

---

## Section 2 — Introduction to Git & GitHub

### 10. What is version control, and name the three things it lets you do according to the lecture?
**Answer:**
Version Control is a system that tracks and manages changes to software code over time.
Three key things it lets developers do:
1. **Track complete project history** and revert to any past snapshot/commit if errors occur.
2. **Branch and experiment safely** on isolated features without affecting the main codebase.
3. **Collaborate seamlessly** with multiple developers on the same codebase simultaneously.

---

### 11. Explain the difference between Git and GitHub in one or two sentences each.
**Answer:**
- **Git:** A distributed, open-source command-line tool installed locally on your computer that tracks file changes, manages branches, and handles commits.
- **GitHub:** A cloud-based web hosting service that stores Git repositories remotely, providing collaboration tools like Pull Requests, Issue Tracking, Code Review, and Actions CI/CD.

---

### 12. Write the two commands needed to configure your Git identity (name and email) for the first time on a new machine.
**Answer:**
```bash
git config --global user.name "Your Name"
git config --global user.email "your.email@example.com"
```

---

### 13. What's the difference between git init and git clone <url>? When would you use each?
**Answer:**
- **`git init`:** Initializes a brand-new, empty local Git repository in an existing local directory. Used when starting a new project from scratch locally.
- **`git clone <url>`:** Downloads an existing remote repository from a URL (e.g., GitHub) along with its complete commit history to your machine. Used when joining an existing project or downloading code.

---

### 14. List, in order, the four commands of the core Git workflow, and what each one does.
**Answer:**
1. **`git status`:** Checks the working directory state and staged/unstaged changes.
2. **`git add <file>` / `git add .`:** Stages modified or new files to prepare them for commit.
3. **`git commit -m "commit message"`:** Saves staged changes into a permanent local commit snapshot with a descriptive message.
4. **`git push origin <branch>`:** Uploads local branch commits to the remote repository (e.g., GitHub).

---

### 15. Write the three commands the lecture uses to connect a local repository to GitHub, upload your local commits, and fetch and merge remote changes.
**Answer:**
1. **Connect local repo to remote:**
   ```bash
   git remote add origin https://github.com/username/repository.name.git
   ```
2. **Upload local commits:**
   ```bash
   git push -u origin main
   ```
3. **Fetch and merge remote changes:**
   ```bash
   git pull origin main
   ```

---

### 16. Write a single command that both creates a new branch called feature/login and switches to it.
**Answer:**
```bash
git checkout -b feature/login
```
*(Or in newer Git versions: `git switch -c feature/login`)*

---

### 17. A merge produces conflict markers like <<<<<<< HEAD, =======, and >>>>>>> branch-name inside a file. What do the two sections between those markers represent, and what must you do before committing?
**Answer:**
- The top section (between `<<<<<<< HEAD` and `=======`) represents the changes on your current local branch (`HEAD`).
- The bottom section (between `=======` and `>>>>>>> branch-name`) represents incoming changes from the branch being merged.
- **What to do before committing:** Manually edit the file to keep desired code, remove all merge conflict marker lines (`<<<<<<<`, `=======`, `>>>>>>>`), test the code, stage the resolved file (`git add <file>`), and commit the merge (`git commit`).

---

### 18. You already pushed a commit with a typo in its message to a shared branch. Write the two commands that fix the message safely without breaking your teammates' clones.
**Answer:**
```bash
git commit --amend -m "Correct commit message"
git push --force-with-lease origin <branch-name>
```

---

### 19. Describe, step by step, how you would squash your last 3 messy commits on a branch into one clean commit before opening a pull request.
**Answer:**
1. Run interactive rebase for the last 3 commits:
   ```bash
   git rebase -i HEAD~3
   ```
2. In the text editor that opens:
   - Keep `pick` for the first (oldest) commit line.
   - Change `pick` to `squash` (or `s`) for the remaining two commits underneath.
3. Save and close the editor.
4. In the second editor prompt, write a clean combined commit message, save, and close.
5. Push the squashed branch to remote:
   ```bash
   git push --force-with-lease origin <branch-name>
   ```

---

### 20. Why might a team choose Git LFS, or a package registry, instead of committing a 40 MB .aar file directly into the repository?
**Answer:**
Committing large binary files (like a 40 MB `.aar` binary) directly into Git bloats the repository size permanently for all future clones, slows down performance, and impairs diff operations. Git LFS or a dependency package registry stores large binaries on dedicated storage servers, keeping the repository small, fast, and light.

---

### 21. What is the difference between a reviewer and an assignee on a pull request?
**Answer:**
- **Reviewer:** A teammate requested to inspect, comment on, and approve/request changes to the code before merging.
- **Assignee:** The person responsible for managing, driving, updating, and completing the work on the pull request.

---

### 22. What's the difference between a label and a milestone on GitHub, and when would you reach for a Project instead of either?
**Answer:**
- **Label:** A tag used to categorize issues/PRs by type or topic (e.g., `bug`, `enhancement`, `documentation`).
- **Milestone:** A target collection of issues/PRs linked to a specific release target or deadline (e.g., `v1.0 Release`).
- **Project:** A visual Kanban or table board used to manage overall team workflows, track task statuses (`To Do`, `In Progress`, `Done`), and organize multi-sprint deliverables across multiple milestones and repositories.

---

### 23. Write a one-line addition to a pull request description that would automatically close issues #42 and #17 the moment the PR merges.
**Answer:**
```text
Closes #42, Closes #17
```
*(Or `Fixes #42, Fixes #17`)*

---

### 24. Name three things the GitHub CLI (gh) lets you do without leaving the terminal, including the exact command for opening a pull request.
**Answer:**
1. Create and open a Pull Request directly from terminal:
   ```bash
   gh pr create
   ```
2. View issue lists or create issues (`gh issue list`, `gh issue create`).
3. Clone remote repositories (`gh repo clone <repo>`).

---

## Section 3 — Activity, Fragments & Navigation

### 25. List the seven Activity lifecycle callbacks in the order they would typically fire when a user opens the app, backgrounds it, and then returns to it (without the Activity being destroyed).
**Answer:**
1. **`onCreate()`** (Activity created)
2. **`onStart()`** (Activity visible)
3. **`onResume()`** (Activity in foreground & interactive)
4. *(User presses Home button / backgrounds app)* -> **`onPause()`**
5. **`onStop()`** (Activity hidden)
6. *(User returns to app)* -> **`onRestart()`**
7. **`onStart()`** -> **`onResume()`** (Activity back in foreground & interactive)

---

### 26. Name three Fragment lifecycle callbacks that don't have a direct Activity equivalent, and briefly explain what each is for.
**Answer:**
1. **`onAttach()`:** Fired when the fragment is first attached to its host activity context.
2. **`onCreateView()`:** Called to inflate and return the fragment's UI view hierarchy.
3. **`onDestroyView()`:** Fired when the fragment's view hierarchy is destroyed and detached from the window, allowing view cleanup while keeping the fragment instance alive.

---

### 27. According to the lecture, why do fragments generally have a lower memory footprint than starting a new activity for the same content?
**Answer:**
Fragments exist inside the window and memory context of a single host Activity. They reuse the host Activity's system resources, window instance, theme configuration, and context without requiring the Android OS to allocate a heavy new system-level activity record and window stack.

---

### 28. Explain how fragments enable more seamless UI transitions than switching between activities.
**Answer:**
Fragments run within the same window hierarchy of one activity, allowing shared element transitions, smooth fragment entry/exit animations, and custom view property animations without window flash or OS activity stack switches.

---

### 29. Give the real-world tablet example from the lecture of when fragments let you show more information without navigating away from the current screen.
**Answer:**
**Master-Detail / Two-Pane Layout:**
On a smartphone, a list fragment opens a new detail activity. On a tablet in landscape mode, both the `ListFragment` (left pane) and `DetailFragment` (right pane) are shown side-by-side inside a single activity, allowing users to view details dynamically without leaving the list screen.

---

### 30. What problem does the Navigation Component solve, and where do you define your app's navigation paths instead of writing manual fragment transactions?
**Answer:**
- **Problem solved:** Simplifies Android app navigation by managing fragment transactions, back stack handling, deep linking, argument passing, and animation transitions automatically.
- **Where defined:** App navigation paths are defined visually and declaratively in an XML resource file called the **Navigation Graph** (`res/navigation/nav_graph.xml`).

---

### 31. Write the two Gradle dependencies needed to use the Navigation Component, and explain what the Safe Args plugin adds on top of them.
**Answer:**
**Gradle Dependencies (Kotlin DSL):**
```kotlin
implementation("androidx.navigation:navigation-fragment-ktx:2.8.0")
implementation("androidx.navigation:navigation-ui-ktx:2.8.0")
```
**Safe Args Plugin:**
Generates compile-time type-safe Direction and Args classes (e.g., `HomeFragmentDirections`), ensuring type-safe navigation and argument passing between destinations without runtime `Bundle` casting errors.

---

### 32. In a nav_graph.xml file, what do startDestination, a <fragment> element, and an <action> element each represent?
**Answer:**
- **`startDestination`:** Defines the initial screen/destination displayed when entering the navigation graph.
- **`<fragment>`:** Represents a single screen destination in the navigation graph linked to a Fragment class.
- **`<action>`:** Represents a directional navigation path from one destination to another, defining transitions, default arguments, and backstack behaviors.

---

### 33. What is a NavHost, and which XML element is typically used to host it inside activity_main.xml?
**Answer:**
- **`NavHost`:** An empty UI container where destinations from the Navigation Graph are swapped in and out.
- **XML Element:** `androidx.fragment.app.FragmentContainerView` (with `android:name="androidx.navigation.fragment.NavHostFragment"`).

---

### 34. Write the Kotlin code to navigate from a fragment to the detailFragment destination, both without Safe Args and with Safe Args enabled.
**Answer:**
**1. Without Safe Args:**
```kotlin
findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
```
**2. With Safe Args:**
```kotlin
val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment()
findNavController().navigate(action)
```

---

### 35. How would you declare a nav_graph.xml <argument> so DetailFragment can safely receive an itemId string, and how would DetailFragment read that argument once Safe Args is enabled?
**Answer:**
**1. Declare argument in `nav_graph.xml` under `<fragment android:id="@+id/detailFragment">`:**
```xml
<argument
    android:name="itemId"
    app:argType="string" />
```
**2. Read argument in `DetailFragment.kt` using `navArgs` delegate:**
```kotlin
val args: DetailFragmentArgs by navArgs()
val itemId: String = args.itemId
```

---

### 36. What line of code lets a toolbar's Up button automatically work with a NavController, and what override do you add to an activity so the system back button integrates with it too?
**Answer:**
**1. Set up toolbar with `NavController`:**
```kotlin
NavigationUI.setupWithNavController(toolbar, navController)
// OR
setupActionBarWithNavController(navController, builder)
```
**2. Override in `MainActivity.kt` for Up/Back navigation support:**
```kotlin
override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp() || super.onSupportNavigateUp()
}
```

---

### 37. What does a <deepLink> element inside a nav_graph.xml <fragment> destination let a user do? Give the example URI from the lecture and what opening it does.
**Answer:**
- **Function:** Allows external apps, web links, or notifications to navigate users directly to a specific deep destination inside the app.
- **Example URI:** `www.example.com/plant/{id}`
- **Behavior:** Opening `www.example.com/plant/42` launches the app directly into `PlantDetailFragment` displaying item `#42`, while constructing a synthetic back stack back to the app home screen.
