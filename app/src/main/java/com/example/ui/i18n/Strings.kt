package com.example.ui.i18n

enum class AppLanguage(val code: String, val displayName: String) {
    ARABIC("ar", "العربية"),
    ENGLISH("en", "English"),
    TURKISH("tr", "Türkçe")
}

object AppStrings {
    fun get(key: String, lang: AppLanguage): String {
        return when (lang) {
            AppLanguage.ARABIC -> arabic[key] ?: english[key] ?: key
            AppLanguage.ENGLISH -> english[key] ?: key
            AppLanguage.TURKISH -> turkish[key] ?: english[key] ?: key
        }
    }

    private val english = mapOf(
        "app_title" to "WhatsChat",
        "tab_chats" to "CHATS",
        "tab_status" to "STATUS",
        "tab_calls" to "CALLS",
        "search_hint" to "Search chats, contacts...",
        "new_chat" to "New Chat",
        "type_message" to "Message",
        "online" to "online",
        "typing" to "typing...",
        "record_audio" to "Hold to record",
        "welcome_title" to "Welcome to WhatsChat",
        "welcome_subtitle" to "Instant guest access. No phone number or password required.",
        "enter_name" to "Enter your nickname",
        "choose_avatar" to "Choose an avatar",
        "start_chatting" to "Start Chatting",
        "settings" to "Settings",
        "profile" to "Profile",
        "theme" to "Theme",
        "language" to "Language",
        "dark_mode" to "Dark Mode",
        "light_mode" to "Light Mode",
        "delete" to "Delete",
        "reply" to "Reply",
        "copy" to "Copy",
        "today" to "TODAY",
        "yesterday" to "YESTERDAY"
    )

    private val arabic = mapOf(
        "app_title" to "WhatsChat",
        "tab_chats" to "الدردشات",
        "tab_status" to "الحالة",
        "tab_calls" to "المكالمات",
        "search_hint" to "بحث في المحادثات وجهات الاتصال...",
        "new_chat" to "محادثة جديدة",
        "type_message" to "اكتب رسالة...",
        "online" to "متصل الآن",
        "typing" to "يكتب الآن...",
        "record_audio" to "اضغط مطولاً للتسجيل",
        "welcome_title" to "أهلاً بك في WhatsChat",
        "welcome_subtitle" to "دخول فوري كضيف. بدون رقم هاتف وبدون كلمة مرور.",
        "enter_name" to "اكتب اسمك المستعار",
        "choose_avatar" to "اختر صورتك الرمزية",
        "start_chatting" to "ابدأ المحادثة الآن",
        "settings" to "الإعدادات",
        "profile" to "الملف الشخصي",
        "theme" to "المظهر",
        "language" to "اللغة",
        "dark_mode" to "الوضع الداكن",
        "light_mode" to "الوضع الفاتح",
        "delete" to "حذف",
        "reply" to "رد",
        "copy" to "نسخ",
        "today" to "اليوم",
        "yesterday" to "أمس"
    )

    private val turkish = mapOf(
        "app_title" to "WhatsChat",
        "tab_chats" to "SOHBETLER",
        "tab_status" to "DURUM",
        "tab_calls" to "ARAMALAR",
        "search_hint" to "Sohbetlerde ara...",
        "new_chat" to "Yeni Sohbet",
        "type_message" to "Mesaj yazın...",
        "online" to "çevrimiçi",
        "typing" to "yazıyor...",
        "record_audio" to "Kayıt için basılı tutun",
        "welcome_title" to "WhatsChat'e Hoş Geldiniz",
        "welcome_subtitle" to "Anında misafir girişi. Telefon numarası veya şifre gerekmez.",
        "enter_name" to "Takma adınızı girin",
        "choose_avatar" to "Avatar seçin",
        "start_chatting" to "Sohbete Başla",
        "settings" to "Ayarlar",
        "profile" to "Profil",
        "theme" to "Tema",
        "language" to "Dil",
        "dark_mode" to "Karanlık Mod",
        "light_mode" to "Aydınlık Mod",
        "delete" to "Sil",
        "reply" to "Cevapla",
        "copy" to "Kopyala",
        "today" to "BUGÜN",
        "yesterday" to "DÜN"
    )
}
