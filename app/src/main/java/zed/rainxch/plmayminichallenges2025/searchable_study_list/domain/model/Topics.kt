package zed.rainxch.plmayminichallenges2025.searchable_study_list.domain.model

data class StudyTopic(val title: String, val subjects: List<String>)

// Study Topics Reference:
// 1. Photosynthesis: Biology, Environmental Science
// 2. World War II Timeline: History, Social Studies
// 3. Introduction to Fractions: Math
// 4. Elements of a Story: Literature, Language Arts
// 5. The Water Cycle: Geography, Environmental Science
// 6. Basic French Greetings: Language, French
// 7. The Human Skeleton: Biology, Health
// 8. Ancient Egyptian Civilizations: History, Archaeology
// 9. Solving for X (Algebra Basics): Math
// 10. Types of Clouds: Geography, Earth Science
// 11. Writing a Thesis Statement: Writing, Language Arts
// 12. The Constitution Explained: Civics, History
// 13. Food Chains and Webs: Biology, Ecology
// 14. Understanding Supply & Demand: Economics, Social Studies
// 15. Literary Devices in Poetry: Literature, English
// 16. Basic Spanish Verbs: Language, Spanish
// 17. Introduction to Coding: Computer Science, Technology
// 18. Earthquake Safety Basics: Geography, Earth Science
// 19. Subject‑Verb Agreement: Grammar, Language Arts
// 20. The Solar System Overview: Astronomy, Science
val studyTopics = listOf(
    StudyTopic("Photosynthesis", listOf("Biology", "Environmental Science")),
    StudyTopic("World War II Timeline", listOf("History", "Social Studies")),
    StudyTopic("Introduction to Fractions", listOf("Math")),
    StudyTopic("Elements of a Story", listOf("Literature", "Language Arts")),
    StudyTopic("The Water Cycle", listOf("Geography", "Environmental Science")),
    StudyTopic("Basic French Greetings", listOf("Language", "French")),
    StudyTopic("The Human Skeleton", listOf("Biology", "Health")),
    StudyTopic("Ancient Egyptian Civilizations", listOf("History", "Archaeology")),
    StudyTopic("Solving for X (Algebra Basics)", listOf("Math")),
    StudyTopic("Types of Clouds", listOf("Geography", "Earth Science")),
    StudyTopic("Writing a Thesis Statement", listOf("Writing", "Language Arts")),
    StudyTopic("The Constitution Explained", listOf("Civics", "History")),
    StudyTopic("Food Chains and Webs", listOf("Biology", "Ecology")),
    StudyTopic("Understanding Supply & Demand", listOf("Economics", "Social Studies")),
    StudyTopic("Literary Devices in Poetry", listOf("Literature", "English")),
    StudyTopic("Basic Spanish Verbs", listOf("Language", "Spanish")),
    StudyTopic("Introduction to Coding", listOf("Computer Science", "Technology")),
    StudyTopic("Earthquake Safety Basics", listOf("Geography", "Earth Science")),
    StudyTopic("Subject‑Verb Agreement", listOf("Grammar", "Language Arts")),
    StudyTopic("The Solar System Overview", listOf("Astronomy", "Science"))
).map { it.toSearchableStudyItem() }

fun StudyTopic.toSearchableStudyItem(): SearchableStudyItem {
    return SearchableStudyItem(
        title = title,
        categories = subjects.toCategories()
    )
}